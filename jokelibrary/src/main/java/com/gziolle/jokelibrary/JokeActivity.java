package com.gziolle.jokelibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gziolle.jokelibrary.R;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();

        if(intent.hasExtra(JokeUtils.JOKE)){
            TextView jokeTextView = (TextView) findViewById(R.id.tv_joke);
            jokeTextView.setText(intent.getStringExtra(JokeUtils.JOKE));
        }
    }
}
