package com.sqlite.user.sqlite.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sqlite.user.sqlite.Config.ConnectionSQLiteHelper;
import com.sqlite.user.sqlite.R;
import com.sqlite.user.sqlite.SqlLite.CreateUsersTable;

public class ManagerUser extends AppCompatActivity {

    EditText inputId, inputName, inputEmail;

    ConnectionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_user);

        conn = new ConnectionSQLiteHelper(getApplicationContext());

        inputId = (EditText) findViewById(R.id.inputUserId);
        inputName = (EditText) findViewById(R.id.inputUserName);
        inputEmail = (EditText) findViewById(R.id.inputUserEmail);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnSearch:
                getUser();
                //getUserSql();
                break;
            case R.id.btnUpdate:
                updateUser();
                break;
            case R.id.btnDelete:
                deleteUser();
                break;
        }
    }

    private void updateUser() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] params ={inputId.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(CreateUsersTable.KEY_NAME, inputName.getText().toString());
        values.put(CreateUsersTable.KEY_EMAIL, inputEmail.getText().toString());

        db.update(CreateUsersTable.TABLE_USER, values,CreateUsersTable.KEY_ID + "=?", params);
        Toast.makeText(getApplicationContext(),"Usuario actualizado con éxito",Toast.LENGTH_LONG).show();
        db.close();
    }

    private void getUserSql() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] params = {inputId.getText().toString()};

        try {

            Cursor cursor = db.rawQuery("SELECT "+CreateUsersTable.KEY_NAME+","+CreateUsersTable.KEY_EMAIL
                            +" FROM "+CreateUsersTable.TABLE_USER+" WHERE "+CreateUsersTable.KEY_ID +"=?", params);
            cursor.moveToFirst();
            inputName.setText(cursor.getString(0));
            inputEmail.setText(cursor.getString(1));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El registro no existe",Toast.LENGTH_LONG).show();
            clearInputs();
        }

    }

    private void getUser() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] params = {inputId.getText().toString()};
        String[] inputs = {CreateUsersTable.KEY_NAME, CreateUsersTable.KEY_EMAIL};

        try {
            Cursor cursor = db.query(CreateUsersTable.TABLE_USER, inputs, CreateUsersTable.KEY_ID + " = ?", params,null,null,null);
            cursor.moveToFirst();
            inputName.setText(cursor.getString(0));
            inputEmail.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"El registro no existe",Toast.LENGTH_LONG).show();
            clearInputs();
        }

    }

    private void deleteUser() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] params = {inputId.getText().toString()};

        db.delete(CreateUsersTable.TABLE_USER,CreateUsersTable.KEY_ID + "=?", params);
        Toast.makeText(getApplicationContext(),"Usuario eliminado con éxito",Toast.LENGTH_LONG).show();
        inputId.setText("");
        clearInputs();
        db.close();
    }

    private void clearInputs() {
        inputName.setText("");
        inputEmail.setText("");
    }
}














































