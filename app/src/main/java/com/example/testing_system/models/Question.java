package com.example.testing_system.models;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Question {
    public Question(String question, String opt1, String opt2, String opt3, String answer) {
        this.question= question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.answer = answer;
    }

    @PrimaryKey(autoGenerate = true)
    public long questionId;

    @ColumnInfo(name = "Question")
    public String question;

    @ColumnInfo(name = "Option1")
    public String opt1;

    @ColumnInfo(name = "Option2")
    public String opt2;

    @ColumnInfo(name = "Option3")
    public String opt3;

    @ColumnInfo(name = "Answer")
    public String answer;

}
