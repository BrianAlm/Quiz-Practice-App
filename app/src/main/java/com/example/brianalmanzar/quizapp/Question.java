package com.example.brianalmanzar.quizapp;

/**
 * Created by brianalmanzar on 3/21/18.
 */

public class Question{

    public static int questionIdCounter = 1;
    protected int questionID;
    protected String question;
    protected String[] possibleAnswers;
    protected String typeOfQuestion;


    public Question(){
        this.idSetter();
    }

    public Question(String quest, String[] possibleAnswers){
        this.question = quest;
        this.possibleAnswers = possibleAnswers;
        this.idSetter();
    }

    public String getQuestion(){
        return this.question;
    }

    public String[] getPossibleAnswers(){
        return this.possibleAnswers;
    }


    /*
       Sets the ID of the question and then increment it the global ID variable
     */
    private void idSetter(){
        this.questionID = Question.questionIdCounter;
        Question.questionIdCounter += 1;
    }


    /*
        Returns the current ID of the question
        @return The question ID
     */
    public int getId(){
        return this.questionID;
    }

    public boolean compareIDWithNumber(int IDNumber){
        return this.questionID == IDNumber;
    }


    public String getTypeOfQuestion(){
        return this.typeOfQuestion;
    }
    /*
     Facilitates the creation of an array from a string literal.

     @param value - The string to be converted to an array
     @param delimeter - marks where we should split the words
     @return String[] - The result of the string converted to an array.
 */
    public static String[] createAnArrayFromString(String value, String delimeter){
        String separator = delimeter;
        if(separator == null){
             separator = " ";
        }
        return value.split(delimeter);
    }

    public static String[] createAnArrayFromString(String value){
        return value.split(" ");
    }

}
