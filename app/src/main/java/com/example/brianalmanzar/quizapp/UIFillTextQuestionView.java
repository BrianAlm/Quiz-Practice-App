package com.example.brianalmanzar.quizapp;

import android.content.Context;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

/**
 * Created by brianalmanzar on 3/24/18.
 */

public class UIFillTextQuestionView extends LinearLayout implements TypeQuestion{
    private int privateID;
    private TextView textToDisplay;
    private EditText textInput;
    private String type = QuestionsStaticText.FillText;

    public UIFillTextQuestionView(Context context){
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
        this.setPadding(25,10,20,10);

        this.textInput = new EditText(this.getContext());
        this.textInput.setHint("Answer Here");
    }

    /*
    Sets the privateID property to match the question ID so when checking the
    answer we can match it with the right question

    @param questionID is the id of the question that is being displayed by this view
 */
    public void setIDToIdentifyTheQuestionItIsDisplaying(int questionID){
        this.privateID = questionID;
    }

    /*
       Return the id of the question that displayed by this view

       @return int - The id of the question
     */
    public int getIDOfTheQuestion(){
        return this.privateID;
    }

    /*
        Sets the question in the TextView and add it to the LinearLayout. Also it creates the RadioButtons and add them to
        the RadioGroup with the options as text.

        @param question - The question to be add it to the LinearLayout as TextView
     */
    public void setDataQuestion(String question){
        createQuestionView(question);
        this.addView(this.textToDisplay);
        this.addView(this.textInput);
    }

    public String getTextFromTheInputText(){
        return this.textInput.getText().toString();
    }

    /*
       Helper function that instantiate and set the text and the font size of the
       Textview question

       @param texto - The text to be add it as question
     */
    private void createQuestionView(String texto){
        this.textToDisplay = new TextView(this.getContext());
        this.textToDisplay.setText(texto);
        this.textToDisplay.setTextColor(Color.rgb(9, 49, 150));
        this.textToDisplay.setTextSize(18);
    }

    /*
     Interface method implementation
     ********** TypeQuestion *********
     */
    public String getTypeOfQuestionView(){
        return this.type;
    }

}

