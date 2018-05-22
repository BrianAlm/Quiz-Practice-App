package com.example.brianalmanzar.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String customMessage;
        int finalCorrectAnswers;

        Intent mainActivity = getIntent();
        String mainActivityMessage = mainActivity.getStringExtra(MainActivity.FINALSCOREMESSAGE);

        try {
            finalCorrectAnswers = Integer.valueOf(mainActivityMessage);
        }finally {
            System.out.println("An error occured trying to cast the correct answers from String to Int. -'Main2Activity.java'- ");
        }

        customMessage = constructMessageBasedOnFinalScore(finalCorrectAnswers);

        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_id));

        TextView resultTextView = layout.findViewById(R.id.score_results);
        TextView customMessageView = layout.findViewById(R.id.custom_message);

        customMessageView.setText(customMessage);
        resultTextView.setText(mainActivityMessage + "/10");

        Toast toastToPresentScore = new Toast(getApplicationContext());
        toastToPresentScore.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
        toastToPresentScore.setDuration(Toast.LENGTH_LONG);
        toastToPresentScore.setView(layout);
        toastToPresentScore.show();
    }


    /*
        @param finalScore - The score of correct answers obtained from the evaluation of the quiz
        @return String - A message constructed based on the final results
     */
    private String constructMessageBasedOnFinalScore(int finalScore){
        String customStringMessage = "";

        if(finalScore >= 8){
            customStringMessage = "Awesome, you did a good work!";
        }else if(finalScore >= 6 && finalScore < 8){
            customStringMessage = "Good work, keep improving and try again!";
        }else{
            customStringMessage = "Keep working hard and try as many time as you need!";
        }
        return customStringMessage;
    }

    public void restarQuiz(View view){
        Intent quizActivity = new Intent(this, MainActivity.class);

        startActivity(quizActivity);
    }
}
