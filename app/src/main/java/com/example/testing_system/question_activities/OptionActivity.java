package com.example.testing_system.question_activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testing_system.R;

public class OptionActivity extends Activity {
    Button btnOption1,btnOption2,btnOption3,btnOption4,btnOption5, btnFinalProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        btnOption1 = (Button) findViewById(R.id.idBtnOption1);
        btnOption2 = (Button) findViewById(R.id.idBtnOption2);
        btnOption3 = (Button) findViewById(R.id.idBtnOption3);
        btnOption4 = (Button) findViewById(R.id.idBtnOption4);
        btnOption5 = (Button) findViewById(R.id.idBtnOption5);
        btnFinalProject = (Button) findViewById(R.id.idBtnFinalTest);

        btnFinalProject.setOnClickListener(v -> {
            Intent intent = new Intent(OptionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        });
        btnOption1.setOnClickListener(v -> {
            Intent intent = new Intent(OptionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        });
        btnOption2.setOnClickListener(v -> {
            Intent intent = new Intent(OptionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        });
        btnOption3.setOnClickListener(v -> {
            Intent intent = new Intent(OptionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        });
        btnOption4.setOnClickListener(v -> {
            Intent intent = new Intent(OptionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        });
        btnOption5.setOnClickListener(v -> {
            Intent intent = new Intent(OptionActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        });
    }
    public static final int ANIMALS = 1;
    public static final int PEOPLE = 2;
    public static final int RANDOM = 3;
    public static final int MUSIC = 4 ;
    public static final int SPORT = 5;
}
