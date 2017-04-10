package com.ivangretic.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int points = 0;
    String correct1 = "Demon";
    String correct2 = "Eternal Darkness";
    private RadioButton button1_1, button1_2, button1_3, button1_4, button4_1, button4_2, button4_3, button4_4;
    private CheckBox checkBox2_1, checkBox2_2, checkBox2_3, checkBox2_4, checkBox2_5, checkBox2_6;
    private CheckBox checkBox5_1, checkBox5_2, checkBox5_3, checkBox5_4, checkBox5_5, checkBox5_6;
    private EditText text1, text2, name;
    private TextView first_text;
    private ScrollView scr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1_1 = (RadioButton) findViewById(R.id.ans1_1); button1_2 = (RadioButton) findViewById(R.id.ans1_2);
        button1_3 = (RadioButton) findViewById(R.id.ans1_3); button1_4 = (RadioButton) findViewById(R.id.ans1_4);
        button4_1 = (RadioButton) findViewById(R.id.ans4_1); button4_2 = (RadioButton) findViewById(R.id.ans4_2);
        button4_3 = (RadioButton) findViewById(R.id.ans4_3); button4_4 = (RadioButton) findViewById(R.id.ans4_4);
        checkBox2_1 = (CheckBox) findViewById(R.id.check2_1); checkBox2_2 = (CheckBox) findViewById(R.id.check2_2);
        checkBox2_3 = (CheckBox) findViewById(R.id.check2_3); checkBox2_4 = (CheckBox) findViewById(R.id.check2_4);
        checkBox2_5 = (CheckBox) findViewById(R.id.check2_5); checkBox2_6 = (CheckBox) findViewById(R.id.check2_6);
        checkBox5_1 = (CheckBox) findViewById(R.id.check5_1); checkBox5_2 = (CheckBox) findViewById(R.id.check5_2);
        checkBox5_3 = (CheckBox) findViewById(R.id.check5_3); checkBox5_4 = (CheckBox) findViewById(R.id.check5_4);
        checkBox5_5 = (CheckBox) findViewById(R.id.check5_5); checkBox5_6 = (CheckBox) findViewById(R.id.check5_6);
        text1 = (EditText) findViewById(R.id.et1);
        text2 = (EditText) findViewById(R.id.et2);
        name = (EditText) findViewById(R.id.name_field);
    }

//    Implementing smooth scroll when use clicks on begin

    public final void focusOnView(View view){
        scr = (ScrollView) findViewById(R.id.scroll);
        first_text = (TextView) findViewById(R.id.first_text);
        scr.post(new Runnable() {
            @Override
            public void run() {
                scr.smoothScrollTo(0, first_text.getTop());
            }
        });
    }

//    If one radio button is clicked, other radio buttons must be unchecked

    public void clickedAnswer1_1(View view){
        button1_2.setChecked(false);
        button1_3.setChecked(false);
        button1_4.setChecked(false);
    }
    public void clickedAnswer1_2(View view){
        button1_1.setChecked(false);
        button1_3.setChecked(false);
        button1_4.setChecked(false);
    }
    public void clickedAnswer1_3(View view){
        button1_1.setChecked(false);
        button1_2.setChecked(false);
        button1_4.setChecked(false);
    }
    public void clickedAnswer1_4(View view){
        button1_1.setChecked(false);
        button1_2.setChecked(false);
        button1_3.setChecked(false);
    }
    public void clickedAnswer4_1(View view){
        button4_2.setChecked(false);
        button4_3.setChecked(false);
        button4_4.setChecked(false);
    }
    public void clickedAnswer4_2(View view){
        button4_1.setChecked(false);
        button4_3.setChecked(false);
        button4_4.setChecked(false);
    }
    public void clickedAnswer4_3(View view){
        button4_1.setChecked(false);
        button4_2.setChecked(false);
        button4_4.setChecked(false);
    }
    public void clickedAnswer4_4(View view){
        button4_1.setChecked(false);
        button4_2.setChecked(false);
        button4_3.setChecked(false);
    }

//    Showing toast message

    public void showResult (View view){
        int totalPoints = submitAnswers();
        String username = name.getText().toString();
        Toast.makeText(this, username + ", your final score is " + totalPoints + "/10", Toast.LENGTH_SHORT).show();
        points = 0;
    }
    public void resetActivity (View view){
        finish();
        startActivity(getIntent());
    }
//    Adding and substracting points depending on what user chooses

    public int submitAnswers(){
        if (button1_3.isChecked()) points++;
        else if (button1_1.isChecked() || button1_2.isChecked() || button1_4.isChecked()) points--;
        if (button4_4.isChecked()) points++;
        else if (button4_1.isChecked() || button4_2.isChecked() || button4_3.isChecked()) points--;
        if (checkBox2_1.isChecked()) points++; if (checkBox2_2.isChecked()) points--;
        if (checkBox2_3.isChecked()) points--; if (checkBox2_4.isChecked()) points++;
        if (checkBox2_5.isChecked()) points--; if (checkBox2_6.isChecked()) points--;
        if (checkBox5_1.isChecked()) points--; if (checkBox5_2.isChecked()) points++;
        if (checkBox5_3.isChecked()) points--; if (checkBox5_4.isChecked()) points++;
        if (checkBox5_5.isChecked()) points++; if (checkBox5_6.isChecked()) points--;
        String string1 = text1.getText().toString();
        String string2 = text2.getText().toString();
        if (string1.equals(correct1)) points += 1;
        if (string2.equals(correct2)) points += 2;
        if (points < 0) points = 0;
        return points;
    }
}
