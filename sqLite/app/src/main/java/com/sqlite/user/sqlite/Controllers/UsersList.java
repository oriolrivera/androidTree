package com.sqlite.user.sqlite.Controllers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sqlite.user.sqlite.Adapters.UserDynamicAdapter;
import com.sqlite.user.sqlite.Config.ConnectionSQLiteHelper;
import com.sqlite.user.sqlite.Models.Users;
import com.sqlite.user.sqlite.R;
import com.sqlite.user.sqlite.SqlLite.CreateUsersTable;

import java.util.ArrayList;

/**
 * Created by USER on 2/27/2018.
 */

public class UsersList extends AppCompatActivity {

    ArrayList<Users> listUsers;
    RecyclerView recyclerView;

    ConnectionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        conn = new ConnectionSQLiteHelper(getApplicationContext(),"UsersDB",null,1);

        listUsers = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerDynamicID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        queryUsers();

        UserDynamicAdapter adapter = new UserDynamicAdapter(listUsers);
        recyclerView.setAdapter(adapter);
    }

    private void queryUsers(){
        SQLiteDatabase db  = conn.getReadableDatabase();

        Users user = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + CreateUsersTable.TABLE_USER, null);

        while (cursor.moveToNext()){
            user = new Users();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));

            listUsers.add(user);
        }
    }
}
