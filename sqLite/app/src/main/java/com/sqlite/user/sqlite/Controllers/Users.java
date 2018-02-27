package com.sqlite.user.sqlite.Controllers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sqlite.user.sqlite.Adapters.UserAdapter;
import com.sqlite.user.sqlite.R;

import java.util.ArrayList;

/**
 * Created by USER on 2/27/2018.
 */

public class Users extends AppCompatActivity {

    ArrayList<String> listData;
    RecyclerView recyclerView;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerID);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listData = new ArrayList<String>();

        for (int i=0; i<= 30; i++){
            listData.add("Item = "+ i);
        }

        UserAdapter adapterData = new UserAdapter(listData);
        recyclerView.setAdapter(adapterData);

    }

}
