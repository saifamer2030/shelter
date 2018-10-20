package com.life.shelter.people.homeless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Supporting extends AppCompatActivity {
    private ArrayList<Sponsor> sponsorItem =new ArrayList<Sponsor>();
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporting);


        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));


        SponsorAdapter items = new SponsorAdapter(this,0,sponsorItem);
        ListView listView = findViewById(R.id.support_list);
        listView.setAdapter(items);
    }
}
