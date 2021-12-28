package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddressForm extends AppCompatActivity implements IConfirmCheck {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.cancelOption:
                DialogFragment dialog = new ConfirmDialogFragment();
                dialog.show(getSupportFragmentManager(), "ConfirmDialogFragment");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void confirmButtonClicked() {
        this.setResult(Activity.RESULT_CANCELED);
        this.finish();
    }

    @Override
    public void cancelButtonClicked() {}

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