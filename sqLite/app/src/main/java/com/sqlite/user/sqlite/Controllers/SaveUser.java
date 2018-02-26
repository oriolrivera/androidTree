package com.sqlite.user.sqlite.Controllers;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.sqlite.user.sqlite.Config.ConnectionSQLiteHelper;
import com.sqlite.user.sqlite.R;
import com.sqlite.user.sqlite.SqlLite.CreateUsersTable;

/**
 * Created by USER on 2/11/2018.
 */

public class SaveUser extends AppCompatActivity {

    EditText keyId, keyName, keyEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);
        Log.d("d", "crear");

        keyId = (EditText) findViewById(R.id.userId);
        keyName = (EditText) findViewById(R.id.userName);
        keyEmail = (EditText) findViewById(R.id.userEmail);
    }

    public void onClick(View view){
        saveUser();
    }

    private void saveUser() {
        Log.d("d", "guardar usuario");
        commitUserSql();
    }

    /*
         provisional method
     */
    private void commitUserSql() {
        ConnectionSQLiteHelper conn = new ConnectionSQLiteHelper(this,"UsersDB",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        String insert = "INSERT INTO "+ CreateUsersTable.TABLE_USER
                +" ( " +CreateUsersTable.KEY_ID+","+CreateUsersTable.KEY_NAME+","+CreateUsersTable.KEY_EMAIL+")" +
                " VALUES ("+keyId.getText().toString()+", "
                + "'"+keyName.getText().toString()+"','"
                + keyEmail.getText().toString()+"')";

        db.execSQL(insert);

        db.close();
    }
}
