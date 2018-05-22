package com.example.brianalmanzar.quizapp;

/**
 * Created by brianalmanzar on 3/21/18.
 */

public class CheckBoxQuestion extends Question implements AnswerChecker{
    private String[] answers;


    public CheckBoxQuestion(String question, String[] answers, String[] possibleAnswers){
        super(question, possibleAnswers);
        this.answers = answers;
        this.typeOfQuestion = QuestionsStaticText.CheckBox;
    }

    /* Planing to use this method to show it as a feedback to the user when answer is wrong */
    public String[] getAnswers(){
        return this.answers;
    }

    /*
        Compare the user answer with the real answer.

        @param answer[] - The user answer(s) to be compared.

        @return boolean - Return weather the user answer match the real answer.
     */
    public boolean checkAnswer(String... answers){
        int userAnswerLen = answers.length;
        int answerLen = this.answers.length;

        if(userAnswerLen != answerLen){
            return false;
        }

        for(int indexUserAnswerArray = 0; indexUserAnswerArray < userAnswerLen; indexUserAnswerArray += 1){
            if(!doesArrayContainsValue(this.answers, answers[indexUserAnswerArray])){
                return false;
            }
        }
        return true;
    }

    /*
       Helper function to check weather an array of values contains one single value

       @param arrayToTraverseForValue - Array with values to compare against with.
       @param value - The value to be found in the array of values.

       @return boolean - Wether the value was found in the array or not.
     */
    private boolean doesArrayContainsValue(String[] arrayToTraverseForValue, String value){
        int lenghtOfTheTraversedArray = arrayToTraverseForValue.length;

        for(int indexOfTheArray = 0; indexOfTheArray < lenghtOfTheTraversedArray; indexOfTheArray += 1){
            if(arrayToTraverseForValue[indexOfTheArray].equals(value)){
                return true;
            }
        }
        return false;
    }
}
