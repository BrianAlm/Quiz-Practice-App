package com.example.brianalmanzar.quizapp;

/**
 * Created by brianalmanzar on 3/21/18.
 */
import android.util.Log;

public class RadioBoxQuestion extends Question implements AnswerChecker{
    private String answer;

    public RadioBoxQuestion(String question, String answer, String[] possibleAnswers){
        super(question, possibleAnswers);
        this.answer = answer;
        this.typeOfQuestion = QuestionsStaticText.RadioBox;
    }

    /*
        @return String - returns the answer stored for this question
     */
    public String getAnswer(){
        return this.answer;
    }


    public boolean checkAnswer(String... answer){
        //Log.i("Radio Box", answer[0]);
        return this.answer.equals(answer[0]);
    }

}
