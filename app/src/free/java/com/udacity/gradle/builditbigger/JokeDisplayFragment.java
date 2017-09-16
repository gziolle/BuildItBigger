package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.gziolle.jokelibrary.JokeActivity;
import com.gziolle.jokelibrary.JokeUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeDisplayFragment extends Fragment implements JokeAsyncTask.AsyncResponse{

    private InterstitialAd mInterstitialAd;

    public JokeDisplayFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button tellJokeButton = (Button) root.findViewById(R.id.button_tell_joke);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).createProgressDialog();
                JokeAsyncTask task = new JokeAsyncTask(JokeDisplayFragment.this);
                task.execute();
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }

    @Override
    public void updateJoke(String joke) {
        final String finalJoke = joke;
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                ((MainActivity)getActivity()).dismissProgressDialog();
                Intent intent = new Intent(getActivity(), JokeActivity.class);
                intent.putExtra(JokeUtils.JOKE, finalJoke);
                startActivity(intent);
            }

            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
        });
    }
}