package com.example.brianalmanzar.quizapp;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by brianalmanzar on 4/5/18.
 */

public class UIQuestionFactory {

    /*
       Creates a QuestionView to represent the question to be displayed.

       @param type  - The type of question that is going to be created, etc... (UICheckBoxQuestionView, UIFillTextBoxQuestionView, ... ).

       @param inContext - The context as required by its parent class (package android.widget.LinearLayout).

       @param withQuestion - A reference to the question about to be displayed by this view to extract the information needed.

       @return LinearLayout - The created object returned upcasted in the form of its parent class.
       ************ (NOTE) It need to be casted down in its original form based on its (@param)type parameter *****************
     */

   public static LinearLayout createAQuestionViewOf(String type, Context inContext, Question withQuestion){
       String questionType = type.toLowerCase();

       switch (questionType){
           case "checkbox":
               UICheckBoxQuestionView checkView = new UICheckBoxQuestionView(inContext);
               checkView.setDataQuesion(withQuestion.getQuestion(), withQuestion.getPossibleAnswers());
               checkView.setIDToIdentifyTheQuestionItIsDisplaying(withQuestion.getId());
               return checkView;
           case "radiobox":
               UIRadioBoxQuestionView radioView = new UIRadioBoxQuestionView(inContext);
               radioView.setDataQuestion(withQuestion.getQuestion(), withQuestion.getPossibleAnswers());
               radioView.setIDToIdentifyTheQuestionItIsDisplaying(withQuestion.getId());
               return  radioView;
           case "filltext":
               UIFillTextQuestionView filltext = new UIFillTextQuestionView(inContext);
               filltext.setDataQuestion(withQuestion.getQuestion());
               filltext.setIDToIdentifyTheQuestionItIsDisplaying(withQuestion.getId());
               return filltext;
           default:
               break;
       }
       return new UIFillTextQuestionView(inContext);
   }



}
