package com.example.brianalmanzar.quizapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    String[] tiresAVehicleMightHave = {"2","5","8","20"};
    String[] answers = {"2","8","5"};
    String[] userAns = {"8", "2","5"};



    private Question ques = new CheckBoxQuestion("How many tires a vehicle could have?", answers, ("2 5 8 20".split(" ")));
    private Question quesTwo = new RadioBoxQuestion("How many tires has a motorcycle?", "2", tiresAVehicleMightHave);
    private Question quesThree = new FillTextQuestion("Your Name?", "Brian", "Brian Ryan Alm".split(" "));

    @Test
    public void addition_isCorrect() throws Exception {

        assertEquals(4, 2 + 2);

        assertEquals("CheckBox Question : ques",true,((CheckBoxQuestion) ques).checkAnswer(userAns));
        assertEquals("RadioBox Question : quesTwo",true, ((RadioBoxQuestion) quesTwo).checkAnswer("2"));
        assertEquals("Fill Text Question : quesThree", true, ((FillTextQuestion) quesThree).checkAnswer("bRIan"));
        assertEquals(3,quesThree.getId());
    }
}