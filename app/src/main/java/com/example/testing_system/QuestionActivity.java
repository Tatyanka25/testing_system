package com.example.testing_system;

import android.os.Parcelable;
import android.os.Parcel;

public class QuestionActivity implements Parcelable {
    private int id;
    private String question, option1, option2, option3;
    private int answer;
    private int categoryID;

    public QuestionActivity() {
    }

    public QuestionActivity(String question, String option1, String option2, String option3,
                    int answer, String difficulty, int categoryID) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answer = answer;
        this.categoryID = categoryID;
    }

    protected QuestionActivity(Parcel in) {
        id = in.readInt();
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        answer = in.readInt();
        categoryID = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeInt(answer);
        dest.writeInt(categoryID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionActivity> CREATOR = new Creator<QuestionActivity>() {
        @Override
        public QuestionActivity createFromParcel(Parcel in) {
            return new QuestionActivity(in);
        }

        @Override
        public QuestionActivity[] newArray(int size) {
            return new QuestionActivity[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}

