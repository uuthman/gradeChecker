package com.example.android.gradechecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText physics;
    EditText mathematics;
    EditText chemistry;
    EditText biology;
    EditText english;
    EditText economics;
    EditText agriculture;
    EditText fmath;

    Bundle extras = new Bundle();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getScores();

    }





    public void getScores(){
         physics = (EditText) findViewById(R.id.physics);
         mathematics = (EditText) findViewById(R.id.math);
         chemistry = (EditText) findViewById(R.id.chemistry);
         biology = (EditText) findViewById(R.id.biology);
         english = (EditText) findViewById(R.id.english);
         economics = (EditText) findViewById(R.id.economics);
         agriculture = (EditText) findViewById(R.id.agric);
         fmath = (EditText) findViewById(R.id.fmath);
    }

    public void getGrade(View view) {
        String setPhy = physics.getText().toString();
        String setMath = mathematics.getText().toString();
        String setChem = chemistry.getText().toString();
        String setBio = biology.getText().toString();
        String setEng = english.getText().toString();
        String setEcons = economics.getText().toString();
        String setAgric = agriculture.getText().toString();
        String fMath = fmath.getText().toString();

        if (!TextUtils.isEmpty(setPhy) || !TextUtils.isEmpty(setMath) || !TextUtils.isEmpty(setChem) || !TextUtils.isEmpty(setBio) || !TextUtils.isEmpty(setEng)
                || !TextUtils.isEmpty(setEcons) || !TextUtils.isEmpty(setAgric) || !TextUtils.isEmpty(fMath)){

        assignGrade(setPhy, "phy");
        assignGrade(setChem,"chem");
        assignGrade(setMath, "math");
        assignGrade(setBio, "bio");
        assignGrade(setEng, "eng");
        assignGrade(setEcons, "econs");
        assignGrade(setAgric, "agric");
        assignGrade(fMath, "fmath");

        showResult();

        }else{
            Toast.makeText(this, "please enter a number", Toast.LENGTH_SHORT).show();
        }
    }

    public void assignGrade(String subject, String key){
        int score = convertScore(subject);
        if(score >= 99.9)
            extras.putString(key, "A+");
        else if(score >= 75)
            extras.putString(key, "A");
        else if(score >= 60)
            extras.putString(key, "B");
        else if(score >= 50)
            extras.putString(key, "C");
        else if(score >= 40)
            extras.putString(key, "D");
        else
            extras.putString(key, "F");
    }

    private int convertScore(String score) {
        try{
            return Integer.parseInt(score);
        }catch (Exception e){
            return 0;
        }
    }

    public void showResult(){
        Intent intent = new Intent(this, GetGrade.class);
        intent.putExtras(extras);
        startActivity(intent);
    }


}
