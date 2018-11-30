package com.example.confix.parqueadero;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "vehicle.db";
    public static final int DATABASE_VERSION = 1;

    String table_vehicle = "CREATE TABLE vehicles(id INTEGER PRIMARY KEY, license TEXT, time_in TEXT, time_out TEXT, cost INTEGER)";

    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_vehicle);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE table_vehicle");
    }
}
