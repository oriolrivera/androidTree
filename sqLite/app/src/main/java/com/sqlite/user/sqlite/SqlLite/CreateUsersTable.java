package com.sqlite.user.sqlite.SqlLite;

/**
 * Created by USER on 2/25/2018.
 */

public class CreateUsersTable {

    public static final String TABLE_USER = "users";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    public static final String CREATE_TABLE_USER="CREATE TABLE " +
            ""+TABLE_USER+" ("+KEY_ID+" " + "INTEGER, "+ KEY_NAME +" TEXT," + KEY_EMAIL + " TEXT )";
}
