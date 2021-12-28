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

public class CommentForm extends AppCompatActivity implements IConfirmCheck{

    private EditText inputComment;

    private String comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_form);

        Intent intent = getIntent();
        comment = intent.getStringExtra(MainActivity.COMMENT);

        inputComment = findViewById(R.id.commentInputText);
        inputComment.setText(comment);
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
        comment = inputComment.getText().toString();
        returnIntent.putExtra(MainActivity.COMMENT, comment);
        this.setResult(Activity.RESULT_OK, returnIntent);
        this.finish();
    }

    public void cancel(View view) {
        this.setResult(Activity.RESULT_CANCELED);
        this.finish();
    }
}