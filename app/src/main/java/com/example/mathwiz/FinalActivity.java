package com.example.mathwiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FinalActivity extends AppCompatActivity {

    public void playAgain(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        Button playAgain = (Button) findViewById(R.id.playAgain);

        Intent intent = getIntent();

        textView2.setText(intent.getStringExtra("score") + "/" + intent.getStringExtra("questions"));
    }
}
