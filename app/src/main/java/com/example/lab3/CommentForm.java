package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CommentForm extends AppCompatActivity {

    private EditText commentInput;

    private String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_form);

        Intent intent = getIntent();
        comment = intent.getStringExtra(MainActivity.COMMENT);

        commentInput = findViewById(R.id.commentInputText);
        commentInput.setText(comment);
    }

    public void save(View view) {
        Intent returnIntent = new Intent();
        comment = commentInput.getText().toString();
        returnIntent.putExtra(MainActivity.COMMENT, comment);
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void cancel(View view) {
        this.setResult(Activity.RESULT_CANCELED);
        this.finish();
    }
}