package com.sqlite.user.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent myIntent = null;

        Log.d("debugin", "" + view.getId() +"");

        switch (view.getId()){
            case R.id.btnAdd:
                myIntent = new Intent(MainActivity.this, SaveUser.class);
                break;
        }
        if (myIntent != null){
            startActivity(myIntent);
        }

    }
}
