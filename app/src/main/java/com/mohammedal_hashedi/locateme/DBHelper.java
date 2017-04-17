package com.mohammedal_hashedi.locateme;

/**
 * Created by hafizuddeen on 1/22/2017.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.*;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DBName";

    private static final int DATABASE_VERSION = 2;

    // Database creation sql statement
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS floor (Mac_Address text, Floor_Number text,  building text, left_or_right text)");
        db.execSQL("INSERT INTO floor (Mac_Address, Floor_Number , building,  left_or_right) VALUES ('18:64:72:73:53:33', '5', 'CDP', 'Right')");
        db.execSQL("INSERT INTO floor (Mac_Address, Floor_Number, building, left_or_right) VALUES ('18:64:72:73:4f:53', '5' , 'CDP', 'Right')");
        db.execSQL("INSERT INTO floor (Mac_Address,Floor_Number, building,  left_or_right) VALUES ('18:64:72:73:5f:c3', '5' , 'CDP','Right')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number,building,  left_or_right) VALUES ('18:64:72:73:53:43', '5','CDP', 'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number, building, left_or_right) VALUES ('18:64:72:73:50:33', '5','CDP', 'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number, building,  left_or_right) VALUES ('18:64:72:73:34:f3', '5','CDP', 'Left')");



        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number, building,  left_or_right) VALUES ('18:64:72:73:4c:f3', '4','CDP', 'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number, building,  left_or_right) VALUES ('18:64:72:73:49:d3', '4','CDP', 'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number, building, left_or_right) VALUES ('18:64:72:73:4d:13', '4','CDP', 'Right')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number , building, left_or_right) VALUES ('18:64:72:73:4b:f3', '4','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number, building, left_or_right) VALUES ('18:64:72:73:34:f3', '4','CDP', 'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number , building,left_or_right) VALUES ('18:64:72:73:4c:13', '4','CDP', 'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:35:d3', '3','CDP',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:36:13', '3','CDP',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:3b:43', '3','CDP',  'Right')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:69:83', '3','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:26:b3', '3','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:34:f3', '3','CDP',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:69:83', '2','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:26:b3', '2','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:65:83', '2','CDP',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:70:73', '1','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:70:63', '1','CDP',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:65:83', '1','CDP',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:4a:d3', 'Ground','CDP', '')");


        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:46:14', 'Ground', 'LP',  'Middle')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:28:24', '4', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:4b:c2', '4', 'FET',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:49:a4', '3', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:4f:b4', '3', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:53:b4', '3', 'FET',  'Right')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:5b:44', '3', 'FET',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:4d:24', '3', 'FET',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:5a:f4', '3', 'FET',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:71:04', '2', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:48:74', '2', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:6f:04', '2', 'FET',  'Right')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:70:14', '2', 'FET',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:70:54', '2', 'FET',  'Left')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:4b:54', '2', 'FET',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:58:23', '1', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:45:b3', '1', 'FET',  'Left')");

        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:47:93', 'Ground', 'FET',  'Right')");
        db.execSQL("INSERT INTO floor(Mac_Address,Floor_Number ,building, left_or_right) VALUES ('18:64:72:73:41:03', 'Ground', 'FET',  'Left')");





    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS floor");
        onCreate(database);
    }

    public Cursor selectRecords(String mac_address) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM floor where Mac_Address = " + "'" + mac_address + "'", null);
        return c;
    }
}
