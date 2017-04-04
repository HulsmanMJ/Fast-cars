package com.example.android.quiz_fastcars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.android.quiz_fastcars.R;

public class MainActivity extends AppCompatActivity {

    // Save variable values after rotation of the screen
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("MyScore", score);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        savedInstanceState.getInt("MyScore");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Global variables
    int score = 0;

    /**
     * This procedure is getting the status of all (radio/checkbox)buttons
     *
     * @param view method is called by start and next buttons
     */
    public void submitQuiz(View view) {

        // Get the name of the respondent
        EditText editText = (EditText) findViewById(R.id.person_name);
        String name = editText.getText().toString();

        // Radiogroup
        RadioGroup groupOne = (RadioGroup) findViewById(R.id.group_1);
        RadioGroup groupTwo = (RadioGroup) findViewById(R.id.group_2);
        RadioGroup groupThree = (RadioGroup) findViewById(R.id.group_3);

        // Question 1
        RadioButton answer11 = (RadioButton) findViewById(R.id.answer11);
        boolean isCheckedAnswer11 = answer11.isChecked();
        RadioButton answer12 = (RadioButton) findViewById(R.id.answer12);
        boolean isCheckedAnswer12 = answer12.isChecked();
        RadioButton answer13 = (RadioButton) findViewById(R.id.answer13);
        boolean isCheckedAnswer13 = answer13.isChecked();
        RadioButton answer14 = (RadioButton) findViewById(R.id.answer14);
        boolean isCheckedAnswer14 = answer14.isChecked();

        // Question 2
        RadioButton answer21 = (RadioButton) findViewById(R.id.answer21);
        boolean isCheckedAnswer21 = answer21.isChecked();
        RadioButton answer22 = (RadioButton) findViewById(R.id.answer22);
        boolean isCheckedAnswer22 = answer22.isChecked();
        RadioButton answer23 = (RadioButton) findViewById(R.id.answer23);
        boolean isCheckedAnswer23 = answer23.isChecked();
        RadioButton answer24 = (RadioButton) findViewById(R.id.answer24);
        boolean isCheckedAnswer24 = answer24.isChecked();

        // Question 3
        RadioButton answer31 = (RadioButton) findViewById(R.id.answer31);
        boolean isCheckedAnswer31 = answer31.isChecked();
        RadioButton answer32 = (RadioButton) findViewById(R.id.answer32);
        boolean isCheckedAnswer32 = answer32.isChecked();

        // Question 4
        CheckBox answer41 = (CheckBox) findViewById(R.id.answer41);
        boolean isCheckedAnswer41 = answer41.isChecked();
        CheckBox answer42 = (CheckBox) findViewById(R.id.answer42);
        boolean isCheckedAnswer42 = answer42.isChecked();
        CheckBox answer43 = (CheckBox) findViewById(R.id.answer43);
        boolean isCheckedAnswer43 = answer43.isChecked();
        CheckBox answer44 = (CheckBox) findViewById(R.id.answer44);
        boolean isCheckedAnswer44 = answer44.isChecked();

        // Question 5
        EditText answer51 = (EditText) findViewById(R.id.answer_robots);
        String isCheckedAnswer5 = answer51.getText().toString();

        // Answers
        answerOne(isCheckedAnswer11, isCheckedAnswer12, isCheckedAnswer13, isCheckedAnswer14);
        answerTwo(isCheckedAnswer21, isCheckedAnswer22, isCheckedAnswer23, isCheckedAnswer24);
        answerThree(isCheckedAnswer31, isCheckedAnswer32);
        answerFour(isCheckedAnswer41, isCheckedAnswer42, isCheckedAnswer43, isCheckedAnswer44);
        answerFive(isCheckedAnswer5);

        // Score
        finalScore(name);

        // Reset all the buttons and text
        score = 0;
        editText.setText(null);
        groupOne.clearCheck();
        groupTwo.clearCheck();
        groupThree.clearCheck();
        answer41.setChecked(false);
        answer42.setChecked(false);
        answer43.setChecked(false);
        answer44.setChecked(false);
        answer51.setText(null);
    }

    /**
     * Check which checkbox was selected in question 1
     *
     * @param checkBox1 is whether or not the user checked the checkbox1
     * @param checkBox2 is whether or not the user checked the checkbox2
     * @param checkBox3 is whether or not the user checked the checkbox3
     * @param checkBox4 is whether or not the user checked the checkbox3
     */
    public void answerOne(boolean checkBox1, boolean checkBox2, boolean checkBox3, boolean checkBox4) {
        if (!checkBox1 && !checkBox2 && checkBox3 && !checkBox4)
            score += 1;
    }

    /**
     * Check which checkbox was selected in question 2
     *
     * @param checkBox1 is whether or not the user checked the checkbox1
     * @param checkBox2 is whether or not the user checked the checkbox2
     * @param checkBox3 is whether or not the user checked the checkbox3
     * @param checkBox4 is whether or not the user checked the checkbox3
     */
    public void answerTwo(boolean checkBox1, boolean checkBox2, boolean checkBox3, boolean checkBox4) {
        if (!checkBox1 && checkBox2 && !checkBox3 && !checkBox4)
            score += 1;
    }

    /**
     * Check which radio button was selected in question 3
     *
     * @param radioButton1 is whether or not the user checked radio button 1
     * @param radioButton2 is whether or not the user checked radio button 2
     */
    public void answerThree(boolean radioButton1, boolean radioButton2) {
        if (radioButton1 && !radioButton2)
            score += 1;
    }

    /**
     * Check which checkbox was selected in question 4
     *
     * @param checkBox1 is whether or not the user checked the checkbox1
     * @param checkBox2 is whether or not the user checked the checkbox2
     * @param checkBox3 is whether or not the user checked the checkbox3
     * @param checkBox4 is whether or not the user checked the checkbox3
     */
    public void answerFour(boolean checkBox1, boolean checkBox2, boolean checkBox3, boolean checkBox4) {
        if (checkBox1 && !checkBox2 && checkBox3 && !checkBox4)
            score += 1;
    }

    /**
     * Check the answer to the open question 5
     *
     * @param userAnswer is the user's answer to question 5
     */
    private void answerFive(String userAnswer) {
        String answer = "Lamborghini";
        if (userAnswer.equals(answer)) {
            score += 1;
        }
    }

    /**
    * Display the quiz result in the Toast message
    */
    public void finalScore(String nameRespondent) {
        Toast.makeText(this, nameRespondent + ": Your score is " + score, Toast.LENGTH_LONG).show();
    }

}