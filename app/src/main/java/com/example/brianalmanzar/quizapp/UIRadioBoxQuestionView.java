package com.example.brianalmanzar.quizapp;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by brianalmanzar on 3/22/18.
 */

public class UIRadioBoxQuestionView extends LinearLayout implements TypeQuestion{
    private int privateID;
    private RadioGroup radioGroup;
    private RadioButton[] radioButtons;
    private TextView question;
    private String[] dataQuestion;
    private String type = "radiobox";

    public UIRadioBoxQuestionView(Context context){
      super(context);

      this.setOrientation(LinearLayout.VERTICAL);
      this.setPadding(25,10,20,10);
      this.radioGroup = new RadioGroup(this.getContext());

    }
    /*
        Sets the question in the TextView and add it to the LinearLayout. Also it creates the RadioButtons and add them to
        the RadioGroup with the options as text.

        @param question - The question to be add it to the LinearLayout as TextView
        @return options[] - The array of options to be add it as RadioButtons
     */

    public void setDataQuestion(String question,String[] options){
        createQuestionView(question);
        this.addView(this.question);

        this.dataQuestion = options;

        int lengthToCreateTheSameAmountOfOptions = options.length;

        radioButtons = new RadioButton[lengthToCreateTheSameAmountOfOptions];

        for(int indexOfOptions = 0; indexOfOptions < lengthToCreateTheSameAmountOfOptions; indexOfOptions+=1){
            radioButtons[indexOfOptions] = new RadioButton(this.getContext());
            radioButtons[indexOfOptions].setText(options[indexOfOptions]);
            this.radioGroup.addView(radioButtons[indexOfOptions]);
        }

        this.addView(radioGroup);

    }

    /*
        Iterate through the RadioButtons and check if any of them is selected

        @return int -  The index of the RadioButton that is selected ( IF ANY ) otherwise it returns -1
     */
    public int checkIfAnyBoxIsSelected(){
        int amountOfRadioBoxesInArray = this.radioButtons.length;

        for(int indexInArray = 0; indexInArray < amountOfRadioBoxesInArray; indexInArray += 1){
            if(this.radioButtons[indexInArray].isChecked()){
                return indexInArray;
            }
        }
        return -1;
    }

    /*
        Gets the text related to a RadioButton that is selected (Checked)

        @param inTheArrayByItsIndex - The index of the RadioButton that is selected

        @return String - The String related to the RadioButton that is selected
     */
    public String getTextRelatedToRadioBoxChecked(int inTheArrayByItsIndex){
        if(inTheArrayByItsIndex == -1){
            return "Null";
        }
        return this.radioButtons[inTheArrayByItsIndex].getText().toString();
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
       Helper function that instantiate and set the text and the font size of the
       Textview question

       @param texto - The text to be add it as question
     */

    private void createQuestionView(String texto){
         this.question = new TextView(this.getContext());
         this.question.setText(texto);
         this.question.setTextColor(Color.rgb(9, 49, 150));
         this.question.setTextSize(18);
    }


    /*
        Interface method implementation
        ********** TypeQuestion *********
    */
    public String getTypeOfQuestionView(){
        return this.type;
    }
}
