package com.example.mathwiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView button0;
    TextView button1;
    TextView button2;
    TextView button3;
    TextView question;
    TextView score;
    TextView timer;
    int userScore = 0;
    int numOfQuestions = 0;
    ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
    int locOfCorrectAnswer;

    public void generateQuestion() {

        Random rand = new Random();

        int x = rand.nextInt(100);
        int y = rand.nextInt(100);

        question.setText(Integer.toString(x) + "+" + Integer.toString(y));

        locOfCorrectAnswer = rand.nextInt(4);

        correctAnswers.clear();

        int incorrectAnswer;

        for ( int i = 0; i < 4; i++ ) {

            if ( i == locOfCorrectAnswer ) {

                correctAnswers.add(x+y);

            } else {

                incorrectAnswer = rand.nextInt(200);

                while ( incorrectAnswer == x + y ) {

                    incorrectAnswer = rand.nextInt(200);

                }


                correctAnswers.add(incorrectAnswer);
            }

        }

        button0.setText(Integer.toString(correctAnswers.get(0)));
        button1.setText(Integer.toString(correctAnswers.get(1)));
        button2.setText(Integer.toString(correctAnswers.get(2)));
        button3.setText(Integer.toString(correctAnswers.get(3)));


    }

    public void checkAnswer(View view) {

        if ( view.getTag().toString().equals(Integer.toString(locOfCorrectAnswer)) ) {

            userScore++;
            Toast.makeText(GameActivity.this, "Correct", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(GameActivity.this, "Wrong", Toast.LENGTH_LONG).show();

        }

        numOfQuestions++;
        score.setText(Integer.toString(userScore) + "/" + Integer.toString(numOfQuestions));
        generateQuestion();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        question = findViewById(R.id.question);
        score = findViewById(R.id.score);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        timer = findViewById(R.id.timer);

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {

                timer.setText("0s");
                Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
                intent.putExtra("score", Integer.toString(userScore));
                intent.putExtra("questions", Integer.toString(numOfQuestions));
                startActivity(intent);

            }

        }.start();

        generateQuestion();
    }
}
