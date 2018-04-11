package com.example.brianalmanzar.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String FINALSCOREMESSAGE = "com.example.brianalmanzar.quizapp.FINALSCORE";
    LinearLayout refToMainView;

    private Question[] questions = {
            new RadioBoxQuestion("Is the Constitution the supreme law of the land?","True",Question.createAnArrayFromString("True False")),
            new RadioBoxQuestion("What do we call the first ten amendments of the Constitution?", "Bill Of Rights", Question.createAnArrayFromString("Bill Of Rights,The Book Of Law,The Law Paper", ",")),
            new RadioBoxQuestion("What is one right or freedom from the first amendment ","Freedom Of Speech",Question.createAnArrayFromString("Freedom Of Speech,Money To Buy a House,Free Education", ",")),
            new CheckBoxQuestion("What are two rights in the Declaration of Independence?",Question.createAnArrayFromString("Liberty Life"), Question.createAnArrayFromString("Life Work Dream Liberty")),
            new FillTextQuestion("How many U.S. Senators are there?","100"),
            new CheckBoxQuestion("We select the President for how many years?",Question.createAnArrayFromString("4"), Question.createAnArrayFromString("6 8 2 4")),
            new CheckBoxQuestion("Who signs bills to become laws?", Question.createAnArrayFromString("the President"), Question.createAnArrayFromString("the main judge,the President,the Vice President",",")),
            new RadioBoxQuestion("Who lived in America before the Europeans arrived?", "Native Americans", Question.createAnArrayFromString("USA Citizens,Native Americans",",")),
            new FillTextQuestion("Who wrote the Declaration of Independence?","Thomas Jefferson"),
            new CheckBoxQuestion("There were 13 orinal states. Select three.", Question.createAnArrayFromString("New York,Maryland,Rhode Island", ","), Question.createAnArrayFromString("Texas,New York,Maryland,Seattle,Los Angeles,Rhode Island",","))
    };

    private LinearLayout[] questionsViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refToMainView = (LinearLayout) findViewById(R.id.main_layout_view_id);

        int questionArrayLength = this.questions.length;

        this.questionsViews = new LinearLayout[questionArrayLength];

        for(int indexOfQuestion = 0; indexOfQuestion < questionArrayLength; indexOfQuestion += 1){
            this.questionsViews[indexOfQuestion] = UIQuestionFactory.createAQuestionViewOf(this.questions[indexOfQuestion].getTypeOfQuestion(),this.getBaseContext(),this.questions[indexOfQuestion]);
            this.refToMainView.addView(this.questionsViews[indexOfQuestion], 0);
        }
    }

    public void validateAnswers(View view){
        int correctQuestions = 0;
        int questionArrayLength = this.questions.length;

        for(int indexOfArrayQuestion = 0; indexOfArrayQuestion < questionArrayLength; indexOfArrayQuestion += 1){
            AnswerChecker questionToCheck = (AnswerChecker) this.questions[indexOfArrayQuestion];
            TypeQuestion UITypeOfQuestion = (TypeQuestion) this.questionsViews[indexOfArrayQuestion];

            if(UITypeOfQuestion.getTypeOfQuestionView().equals("filltext")){
                UIFillTextQuestionView fillText = (UIFillTextQuestionView) UITypeOfQuestion;
                if(questionToCheck.checkAnswer(fillText.getTextFromTheInputText())){
                    correctQuestions += 1;
                }
            }else if(UITypeOfQuestion.getTypeOfQuestionView().equals("radiobox")){
                UIRadioBoxQuestionView radioBox = (UIRadioBoxQuestionView) UITypeOfQuestion;
                if(questionToCheck.checkAnswer(radioBox.getTextRelatedToRadioBoxChecked(radioBox.checkIfAnyBoxIsSelected()))){
                    correctQuestions += 1;
                }
            }else if(UITypeOfQuestion.getTypeOfQuestionView().equals("checkbox")){
                UICheckBoxQuestionView checkBox = (UICheckBoxQuestionView) UITypeOfQuestion;
                if(questionToCheck.checkAnswer(checkBox.checksCheckboxChecked())){
                    correctQuestions += 1;
                }
            }
        }

        //Segue to a new activity
        Intent finalScore = new Intent(this, Main2Activity.class);
        finalScore.putExtra(FINALSCOREMESSAGE, String.valueOf(correctQuestions));
        startActivity(finalScore);

        Log.i("Correct Answers",String.valueOf(correctQuestions));
    }
}
