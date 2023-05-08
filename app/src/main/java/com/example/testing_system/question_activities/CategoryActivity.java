package com.example.testing_system.question_activities;

public class CategoryActivity {
    public static final int ANIMALS = 1;
    public static final int PEOPLE = 2;
    public static final int RANDOM = 3;
    public static final int MUSIC = 4 ;
    public static final int SPORT = 5;



    private int id;
    private String name;


    public CategoryActivity(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
