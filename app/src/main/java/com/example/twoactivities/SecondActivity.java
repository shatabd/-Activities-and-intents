package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
public static final String EXTRA_REPLY="com.example.twoactivities.extra.REPLY";
    private EditText mReply;

    // Creating a response Intent in the second Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply=findViewById(R.id.editText_second);
        Intent intent=getIntent();
        String message =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView=findViewById(R.id.text_message);
        textView.setText(message);

    }

    public void returnReply(View view) {
        //returnReply() method, get the text of the EditText as a string:
        String reply=mReply.getText().toString();
        Intent replyIntent=new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}