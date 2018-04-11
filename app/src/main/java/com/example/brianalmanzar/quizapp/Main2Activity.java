package com.example.brianalmanzar.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent mainActivity = getIntent();
        String mainActivityMessage = mainActivity.getStringExtra(MainActivity.FINALSCOREMESSAGE);

        TextView resultTextView = (TextView) findViewById(R.id.score_results);

        resultTextView.setText(mainActivityMessage + "/10");
    }
}
