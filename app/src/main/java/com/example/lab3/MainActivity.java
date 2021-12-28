package com.example.lab3;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textName;
    private TextView textAddress;
    private TextView textComment;

    public static final String NAME = "NAME";
    public static final String ADDRESS = "ADDRESS";
    public static final String COMMENT = "COMMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName = findViewById(R.id.textName);
        textAddress = findViewById(R.id.textAddress);
        textComment = findViewById(R.id.textComment);
    }

    private ActivityResultLauncher<Intent> formActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent resultData = result.getData();

                    String name = resultData.getStringExtra(NAME);
                    if (name != null)
                        textName.setText(name);
                    String address = resultData.getStringExtra(ADDRESS);
                    if (address != null)
                        textAddress.setText(address);
                    String comment = resultData.getStringExtra(COMMENT);
                    if (comment != null)
                        textComment.setText(comment);
                }
            });



    public void editName(View view) {
        Intent intent = new Intent(MainActivity.this, NameForm.class);
        String name = textName.getText().toString();
        intent.putExtra(NAME, name);
        formActivityResultLauncher.launch(intent);
    }

    public void editAddress(View view) {
        Intent intent = new Intent(MainActivity.this, AddressForm.class);
        String address = textAddress.getText().toString();
        intent.putExtra(ADDRESS, address);
        formActivityResultLauncher.launch(intent);
    }

    public void editComment(View view) {
        Intent intent = new Intent(MainActivity.this, CommentForm.class);
        String comment = textComment.getText().toString();
        intent.putExtra(COMMENT, comment);
        formActivityResultLauncher.launch(intent);
    }
}