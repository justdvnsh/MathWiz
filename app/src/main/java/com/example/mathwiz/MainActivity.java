package com.example.mathwiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView intro;
    TextView timer;
    TextView score;
    TextView question;
    Button start;

    public void start(View view) {

        intro.setVisibility(View.INVISIBLE);
        start.setVisibility(View.INVISIBLE);
        timer.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intro = ( TextView ) findViewById(R.id.intro);

        start = ( Button ) findViewById(R.id.start);

        score = ( TextView ) findViewById(R.id.score);

        question = ( TextView ) findViewById(R.id.question);

        timer = ( TextView ) findViewById(R.id.timer);
    }
}
