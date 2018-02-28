package com.sqlite.user.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.sqlite.user.sqlite.Controllers.ManagerUser;
import com.sqlite.user.sqlite.Controllers.SaveUser;
import com.sqlite.user.sqlite.Controllers.Users;
import com.sqlite.user.sqlite.Controllers.UsersList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent myIntent = null;

        Log.d("debugin", "" + view.getId() +"");

        /*
         Redirect to different activities
          */
        switch (view.getId()){
            case R.id.btnAdd:
                myIntent = new Intent(MainActivity.this, SaveUser.class);
                break;
            case R.id.btnRecyclerViewBasic:
                myIntent = new Intent(MainActivity.this, Users.class);
                break;
            case R.id.btnRecyclerViewUser:
                myIntent = new Intent(MainActivity.this, UsersList.class);
                break;
            case R.id.btnManagerUser:
                myIntent = new Intent(MainActivity.this, ManagerUser.class);
                break;

        }
        if (myIntent != null){
            startActivity(myIntent);
        }

    }
}
