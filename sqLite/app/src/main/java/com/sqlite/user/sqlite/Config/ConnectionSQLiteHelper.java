package com.sqlite.user.sqlite.Config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sqlite.user.sqlite.SqlLite.CreateUsersTable;

/**
 * Created by USER on 2/25/2018.
 */

public class ConnectionSQLiteHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "UsersDB";

    public ConnectionSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateUsersTable.CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CreateUsersTable.CREATE_TABLE_USER);
        onCreate(db);
    }
}
