package com.example.testing_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "users.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "users";
    public static final String ID_COL = "id";
    public static final String LOGIN_COL = "login";
    public static final String PASSWORD_COL = "password";
    public static final String NAME_COL = "name";
    public static final String SURNAME_COL = "surname";
    public static final String MIDDLENAME_COL = "middle_name";
    public static final String DATEOFBIRTH_COL = "date_of_birth";
    public static final String EMAIL_COL = "email";
    public static final String NUMBER_COL = "mobile_number";
    public static final String QUESTION_COL = "secret_question";
    public static final String ANSWER_COL = "answer";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LOGIN_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + NAME_COL + " TEXT,"
                + SURNAME_COL + " TEXT,"
                + MIDDLENAME_COL + " TEXT,"
                + DATEOFBIRTH_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + NUMBER_COL + " TEXT,"
                + QUESTION_COL + " TEXT,"
                + ANSWER_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String userLogin, String userPassword, String userName, String userSurname, String userMiddleName, String userDateOfBirth, String userEmail, String userNumber, String userQuestion, String userAnswer) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(LOGIN_COL, userLogin);
        values.put(PASSWORD_COL, userPassword);
        values.put(NAME_COL, userName);
        values.put(SURNAME_COL, userSurname);
        values.put(MIDDLENAME_COL, userMiddleName);
        values.put(DATEOFBIRTH_COL, userDateOfBirth);
        values.put(EMAIL_COL, userEmail);
        values.put(NUMBER_COL, userNumber);
        values.put(QUESTION_COL, userQuestion);
        values.put(ANSWER_COL, userAnswer);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}