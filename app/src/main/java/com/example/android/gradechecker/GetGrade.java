package com.example.android.gradechecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GetGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_grade);

        //PHYSICS
        TextView physics = (TextView) findViewById(R.id.get_phy);

        //CHEMISTRY
        TextView chemistry= (TextView) findViewById(R.id.get_chem);

        //BIOLOGY
        TextView biology= (TextView) findViewById(R.id.get_bio);

        //ECONOMICS
        TextView economics= (TextView) findViewById(R.id.get_econs);

        //AGRICULTURE
        TextView agriculture = (TextView) findViewById(R.id.get_agric);

        //MATHEMATICS
        TextView mathematics= (TextView) findViewById(R.id.get_math);

        //ENGLISH
        TextView english= (TextView) findViewById(R.id.get_eng);

        //FURTHER MATH
        TextView fMath= (TextView) findViewById(R.id.get_fmath);

        //getting the intent value
        Intent intent = getIntent();

        Bundle extras = intent.getExtras();


             String value_phy = extras.getString("phy");
            physics.setText(value_phy);

            String value_chem = extras.getString("chem");
            chemistry.setText(value_chem);

            String value_bio = extras.getString("bio");
            biology.setText(value_bio);

             String value_econ = extras.getString("econs");
            economics.setText(value_econ);

             String value_agric = extras.getString("agric");
            agriculture.setText(value_agric);

             String value_math = extras.getString("math");
            mathematics.setText(value_math);

             String value_eng = extras.getString("eng");
            english.setText(value_eng);

             String value_fmath = extras.getString("fmath");
            fMath.setText(value_fmath);
        }


    public void closeTerm(View view) {
        Intent showPage = new Intent(this,MainActivity.class);
        startActivity(showPage);
        finish();
    }
}
