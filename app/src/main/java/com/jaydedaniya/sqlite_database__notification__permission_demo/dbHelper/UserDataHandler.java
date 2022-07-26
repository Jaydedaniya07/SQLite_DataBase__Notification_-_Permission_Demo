package com.jaydedaniya.sqlite_database__notification__permission_demo.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jaydedaniya.sqlite_database__notification__permission_demo.UserDataClass;

import java.util.ArrayList;

public class UserDataHandler extends SQLiteOpenHelper {

    public static final String DBNAME = "UserLoginDetails.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "userdetails", ID = "id", NAME = "username", NUMBER = "usernumber", EMAIL = "useremail", PASSWORD = "userpass";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    NAME + " TEXT," +
                    NUMBER + " TEXT," +
                    EMAIL + " TEXT," +
                    PASSWORD + " TEXT)";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE;

    public UserDataHandler(@Nullable Context context) {
        super(context, DBNAME, null, DATABASE_VERSION);
    }

    public UserDataHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBNAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean saveUserDetails(UserDataClass userDataClass){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, userDataClass.getUserName());
        contentValues.put(NUMBER, userDataClass.getUserNumber());
        contentValues.put(EMAIL, userDataClass.getUserEmail());
        contentValues.put(PASSWORD, userDataClass.getUserPass());

        return userDataClass.getUserId() == 0 ? db.insert(TABLE,null,contentValues) > 0 :
                db.update(TABLE,contentValues,ID + " = ?", new String[]{String.valueOf(userDataClass.getUserId())}) > 0;
    }

    public boolean deleteUserDetails(UserDataClass userDataClass){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE, ID + "=?", new String[]{String.valueOf(userDataClass.getUserId())}) > 0;
    }

    public UserDataClass getSingleUserDetails(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        UserDataClass userDataClass = new UserDataClass();
        String query = "SELECT * FROM " + TABLE + " WHERE " + ID + " = " + id;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToNext()){
            userDataClass.setUserId(cursor.getInt((int)cursor.getColumnIndex(ID)));
            userDataClass.setUserName(cursor.getString((int)cursor.getColumnIndex(NAME)));
            userDataClass.setUserNumber(cursor.getString((int)cursor.getColumnIndex(NUMBER)));
            userDataClass.setUserEmail(cursor.getString((int)cursor.getColumnIndex(EMAIL)));
        }
        cursor.close();
        return userDataClass;
    }

    public ArrayList<UserDataClass> getAllUserDetails(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UserDataClass> allUserDatumDetails = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE;
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext())
        {
            UserDataClass userDataClass = new UserDataClass();
            userDataClass.setUserId(cursor.getInt((int)cursor.getColumnIndex(ID)));
            userDataClass.setUserName(cursor.getString((int)cursor.getColumnIndex(NAME)));
            userDataClass.setUserNumber(cursor.getString((int)cursor.getColumnIndex(NUMBER)));
            userDataClass.setUserEmail(cursor.getString((int)cursor.getColumnIndex(EMAIL)));
            allUserDatumDetails.add(userDataClass);
        }
        cursor.close();
        return allUserDatumDetails;
    }

}
