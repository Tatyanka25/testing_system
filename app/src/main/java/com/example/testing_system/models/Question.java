package com.example.testing_system.models;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Question {
    public Question(String question, String opt1, String opt2, String opt3, String answer, long category_id) {
        this.question= question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.answer = answer;
        this.category_id = category_id;
    }

    @PrimaryKey(autoGenerate = true)
    public long questionId;

    @ColumnInfo(name = "question")
    public String question;

    @ColumnInfo(name = "option1")
    public String opt1;

    @ColumnInfo(name = "option2")
    public String opt2;

    @ColumnInfo(name = "option3")
    public String opt3;

    @ColumnInfo(name = "answer")
    public String answer;

    @ColumnInfo(name = "category_id")
    public long category_id;
}
