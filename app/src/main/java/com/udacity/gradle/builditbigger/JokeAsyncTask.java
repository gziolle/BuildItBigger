package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import com.gziolle.builditbigger.jokeApi.JokeApi;

import java.io.IOException;

/**
 * BuildItBigger
 * Created by Guilherme Ziolle on 05/09/2017.
 * gziolle@gmail.com
 */

public class JokeAsyncTask extends AsyncTask<Void, Void, String>{

    private static JokeApi jokeService = null;
    private AsyncResponse mResponse;

    public JokeAsyncTask(AsyncResponse response){
        mResponse = response;
    }

    public interface AsyncResponse{
        void updateJoke(String joke);
    }

    @Override
    protected String doInBackground(Void... params) {
        if(jokeService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            jokeService = builder.build();
        }
        try {
            String joke = jokeService.tellJoke().execute().getJoke();
            return joke;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        if(mResponse != null){
            mResponse.updateJoke(joke);
        }
    }
}
