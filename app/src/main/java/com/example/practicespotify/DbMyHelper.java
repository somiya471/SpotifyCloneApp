package com.example.practicespotify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbMyHelper extends SQLiteOpenHelper {
    public DbMyHelper(@Nullable Context context) {
        super(context, "PlaylistDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table PlaylistSong(title TEXT primary key,artist TEXT,imageid int,song TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists PlaylistSong");
        onCreate(db);

    }

    public Boolean insertuserdata(String title,String artist,int imageid,String song){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",title);
        contentValues.put("artist",artist);
        contentValues.put("imageid",imageid);
        contentValues.put("song",song);
        long result = db.insert("PlaylistSong",null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from PlaylistSong",null);
        return cursor;
    }
}
