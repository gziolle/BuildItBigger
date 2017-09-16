package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gziolle.jokelibrary.JokeActivity;
import com.gziolle.jokelibrary.JokeUtils;

/**
 * BuildItBigger
 * Created by Guilherme Ziolle on 12/09/2017.
 * gziolle@gmail.com
 */

public class JokeDisplayFragment extends Fragment implements JokeAsyncTask.AsyncResponse{

    public JokeDisplayFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button tellJokeButton = (Button) rootView.findViewById(R.id.button_tell_joke);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).createProgressDialog();
                JokeAsyncTask task = new JokeAsyncTask(JokeDisplayFragment.this);
                task.execute();
            }
        });
        return rootView;
    }

    @Override
    public void updateJoke(String joke) {
        ((MainActivity) getActivity()).dismissProgressDialog();
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeUtils.JOKE, joke);
        startActivity(intent);
    }
}
