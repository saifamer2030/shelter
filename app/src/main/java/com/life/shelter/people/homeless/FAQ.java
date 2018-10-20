package com.life.shelter.people.homeless;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FAQ extends AppCompatActivity {
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);



        VideoView vviw= findViewById(R.id.videoView);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vviw);
        Uri uri=Uri.parse("android.resource://com.life.shelter.people.homeless/"+R.raw.test);
        vviw.setMediaController(mediaController);
        vviw.setVideoURI(uri);
        vviw.requestFocus();
        vviw.start();

    }
}
