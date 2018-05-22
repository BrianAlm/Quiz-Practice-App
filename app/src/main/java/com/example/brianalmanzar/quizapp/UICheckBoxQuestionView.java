package com.example.brianalmanzar.quizapp;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.TextView;
import android.graphics.Color;
import java.util.ArrayList;
import android.util.Log;

/**
 * Created by brianalmanzar on 3/26/18.
 */

public class UICheckBoxQuestionView extends LinearLayout implements TypeQuestion{
    private int privateID;
    private TextView question;
    private CheckBox[] options;
    private String[] dataQuesion;
    private String type = QuestionsStaticText.CheckBox;

    public UICheckBoxQuestionView(Context context){
        super(context);

        this.setOrientation(LinearLayout.VERTICAL);
        this.setPadding(25,10,20,10);
    }


    /*
    Sets the question in the TextView and add it to the LinearLayout. Also it creates the CheckBox and add it to
    the LinearLayout with the options as text.

    @param question - The question to be add it to the LinearLayout as TextView.

    @param options[] - The array of options to be add it as RadioButtons.
 */
    public void setDataQuesion(String quesion, String[] options){
        this.createQuestionView(quesion);
        this.addView(this.question);

        int amountOfOptionsToBeCreated = options.length;
        this.options = new CheckBox[amountOfOptionsToBeCreated];

        for(int indexOfOptions = 0; indexOfOptions < amountOfOptionsToBeCreated; indexOfOptions += 1){
            this.options[indexOfOptions] = new CheckBox(this.getContext());
            this.options[indexOfOptions].setText(options[indexOfOptions]);
            this.addView(this.options[indexOfOptions]);
        }
    }


    /*
       Iterates through the checkboxes of the question to check which one are true.

       @return String[] - The text related to the checkboxes that are found checked.
     */
    public String[] checksCheckboxChecked(){
        int amountOfCheckBoxInView = this.options.length;
        String[] optionsSelectedToReturn;
        ArrayList<String> optionsSelected = new ArrayList<>();

        for(int indexOfOptions = 0; indexOfOptions < amountOfCheckBoxInView; indexOfOptions += 1){
            if(this.options[indexOfOptions].isChecked()){
                optionsSelected.add(getTextRelatedToCheckBoxChecked(indexOfOptions));
            }
        }

        int optionSelectedSize = optionsSelected.size();
        optionsSelectedToReturn = new String[optionsSelected.size()];

        for(int indexOptions = 0; indexOptions < optionSelectedSize; indexOptions+=1){
            optionsSelectedToReturn[indexOptions] = optionsSelected.remove(0);
        }
        //Log.i("UICheckBox :: ", String.valueOf(optionsSelectedToReturn.length));
        return optionsSelectedToReturn;
    }


    /*
    Gets the text related to a CheckBox that is selected (Checked)

    @param inTheArrayByItsIndex - The index of the Checkbox that is selected

    @return String - The String related to the CheckBox that is selected
 */
    public String getTextRelatedToCheckBoxChecked(int inTheArrayByItsIndex){
        return this.options[inTheArrayByItsIndex].getText().toString();
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
