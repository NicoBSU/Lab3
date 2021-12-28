package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameForm extends AppCompatActivity {

    private EditText inputName;
    private EditText inputSurname;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_form);

        Intent intent = getIntent();
        name = intent.getStringExtra(MainActivity.NAME);

        String[] separatedName = name.split(" ", 2);
        inputName = findViewById(R.id.nameInputText);
        inputSurname = findViewById(R.id.surnameInputText);
        inputName.setText(separatedName[0]);

        if (separatedName.length > 1)
            inputSurname.setText(separatedName[1]);
    }

    public void save(View view) {
        Intent returnIntent = new Intent();
        name = inputName.getText().toString() + " " + inputSurname.getText().toString();
        returnIntent.putExtra(MainActivity.NAME, name);
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void cancel(View view) {
        this.setResult(Activity.RESULT_CANCELED);
        this.finish();
    }
}