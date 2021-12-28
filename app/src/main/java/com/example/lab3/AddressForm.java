package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddressForm extends AppCompatActivity {

    private EditText inputCountry;
    private EditText inputCity;
    private EditText inputAddress;

    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_form);

        Intent intent = getIntent();
        address = intent.getStringExtra(MainActivity.ADDRESS);
        String[] addressParts = address.split(", ", 3);

        System.out.println(address);

        inputCountry = findViewById(R.id.countryInputText);
        inputCity = findViewById(R.id.cityInputText);
        inputAddress = findViewById(R.id.addressInputText);

        inputCountry.setText(addressParts[0]);
        if (addressParts.length > 1)
            inputCity.setText(addressParts[1]);
        if (addressParts.length > 2)
            inputAddress.setText(addressParts[2]);
    }

    public void save(View view) {
        Intent returnIntent = new Intent();
        address = inputCountry.getText().toString() + ", "
                + inputCity.getText().toString() + ", "
                + inputAddress.getText().toString();
        returnIntent.putExtra(MainActivity.ADDRESS, address);
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void cancel(View view) {
        this.setResult(Activity.RESULT_CANCELED);
        this.finish();
    }
}