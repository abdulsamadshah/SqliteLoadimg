package com.example.sqliteloadimg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {

    public static String DBNAME = "samad.db";
    public static int DBVERSION = 10;

    public Dbhelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table asdata" + "(id integer primary key autoincrement," +
                        "userimg text," +
                        "name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists asdata");
        onCreate(db);
    }

    public boolean insertOrder(String name, String userimg) {

        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("userimg", userimg);

        long id = database.insert("asdata", null, values);
        if (id <= 0) {
            return true;
        } else {
            return true;
        }

    }


    //read karne ka code
    public ArrayList<ReadModels> getOrders() {
        ArrayList<ReadModels> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select name,userimg from asdata", null);
        if (cursor.moveToNext()) {
            while (cursor.moveToNext()) {
                ReadModels model = new ReadModels();
                model.setName(cursor.getString(0) + "");
                model.setUserimg(cursor.getString(1) + "");

                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }
}
