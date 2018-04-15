package com.example.brianalmanzar.quizapp;

import android.util.Log;

/**
 * Created by brianalmanzar on 3/21/18.
 */

public class FillTextQuestion extends Question implements AnswerChecker {
    private String answer;

    public FillTextQuestion(String question, String answer){
        super(question, new String[0]);
        this.answer = answer.toLowerCase();
        this.typeOfQuestion = QuestionsStaticText.FillText;
    }

    public FillTextQuestion(String question, String answer, String[] possibleAnswers){
        super(question,possibleAnswers);
        this.answer = answer.toLowerCase();
        this.typeOfQuestion = QuestionsStaticText.FillText;
    }

    public String getAnswer(){
        return this.answer;
    }

    public boolean checkAnswer(String... answer){
        String lowerCaseAnswer = answer[0].toLowerCase();
        Log.i("Message :: ", lowerCaseAnswer + Boolean.toString(this.answer.equals(lowerCaseAnswer)));
        Log.i("Answer :: ", this.answer);
        return this.answer.equals(lowerCaseAnswer);
    }


}
