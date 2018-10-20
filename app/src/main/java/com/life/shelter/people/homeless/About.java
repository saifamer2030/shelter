package com.life.shelter.people.homeless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class About extends AppCompatActivity {



        ImageView face,twitter,insagram;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about);
            face =findViewById(R.id.fb);
            twitter = findViewById(R.id.twitt);
            insagram = findViewById(R.id.insta);

            face.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"facebook",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),WebActivity.class);
                    String url="https://www.facebook.com/groups/arab.coders.Professionals/?multi_permalinks=1881605645481216&notif_id=1536014616447503&notif_t=group_activity";
                    intent.putExtra("url",url);
                    startActivity(intent);

                }
            });

            twitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"twitter",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),WebActivity.class);
                    String url="https://twitter.com/?lang=ar";
                    intent.putExtra("url",url);
                    startActivity(intent);


                }
            });
            insagram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"instagram",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(),WebActivity.class);
                    String url="https://www.instagram.com";
                    intent.putExtra("url",url);
                    startActivity(intent);


                }
            });
        }
    }


