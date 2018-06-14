package com.example.spinner.spinner;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Spinner sOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String,String> myMap = new HashMap<String,String>();

        String[] newItem = {"item11", "item12"};

        sOpciones = (Spinner) findViewById(R.id.idSpinner);

        myMap.put("item10", "item 10");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, newItem);
        sOpciones.setAdapter(adapter);



        Resources res = getResources();
        String[] items = res.getStringArray(R.array.items);


        sOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(), "Str Valor = "+ parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
               // Toast.makeText(parent.getContext(), "valor = "+ parent.getSelectedItemPosition(), Toast.LENGTH_LONG).show();
                //Toast.makeText(parent.getContext(), "valor = "+ parent.getSelectedItemPosition(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
