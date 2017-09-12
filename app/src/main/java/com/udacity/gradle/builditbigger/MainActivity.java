package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.gziolle.jokelibrary.JokeActivity;
import com.gziolle.jokelibrary.JokeUtils;


public class MainActivity extends AppCompatActivity implements JokeAsyncTask.AsyncResponse {

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        createProgressDialog();
        JokeAsyncTask task = new JokeAsyncTask(this);
        task.execute();
    }

    @Override
    public void updateJoke(String joke) {
        if(mProgressDialog != null){
            mProgressDialog.dismiss();
        }
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeUtils.JOKE, joke);
        startActivity(intent);
    }

    private void createProgressDialog(){
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.progress_dialog_message));
        mProgressDialog.setCancelable(true);
        mProgressDialog.show();
    }
}
