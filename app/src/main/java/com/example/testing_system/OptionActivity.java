package com.example.testing_system;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionActivity extends Activity {

    Button btnOption1,btnOption2,btnOption3,btnOption4,btnFinalProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnOption1 = (Button) findViewById(R.id.idBtnOption1);
        btnOption2 = (Button) findViewById(R.id.idBtnOption2);
        btnOption3 = (Button) findViewById(R.id.idBtnOption3);
        btnOption4 = (Button) findViewById(R.id.idBtnOption4);
        btnFinalProject = (Button) findViewById(R.id.idBtnFinalTest);

        btnFinalProject.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
         Intent intent = new Intent(OptionActivity.this, QuestionActivity.class);
         startActivity(intent);
         finish();
            }
        });
        btnFinalProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this,
                        FinalTestActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this,
                        QuestionActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this,
                        QuestionActivity.class);
                startActivity(intent);
                finish();}
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this,
                        QuestionActivity.class);
                startActivity(intent);
                finish();}
        });

        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this,
                        QuestionActivity.class);
                startActivity(intent);
                finish();}
        });
    }
}
