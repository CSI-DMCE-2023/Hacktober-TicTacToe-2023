package com.example.tictactoe.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
static String name = "tictactoe.db";
static int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, name, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table players(gname TEXT,email TEXT,password TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table players");
        onCreate(db);
    }

    public String SignUp(String gnameS,String email,String pass)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues params=new ContentValues();
        params.put("gname",gnameS);
        params.put("email",email);
        params.put("password",pass);
        db.insert("players",null,params);
        return "Success";
    }

    public String Login(String emaill,String passl)
    {
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("select gname from players where email=? and password=?", new String[]{emaill, passl});
        if (cursor.moveToFirst())
        {
            return (cursor.getString(cursor.getColumnIndex("gname")));
        }else{
            return ("INVALID");
        }
    }
}
