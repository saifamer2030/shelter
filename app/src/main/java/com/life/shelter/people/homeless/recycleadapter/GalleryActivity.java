package com.life.shelter.people.homeless.recycleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.life.shelter.people.homeless.R;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_adress")
                && getIntent().hasExtra("image_city")&& getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageAdress = getIntent().getStringExtra("image_adress");
            String imageCity = getIntent().getStringExtra("image_city");


            setImage(imageUrl, imageName ,imageAdress,imageCity);
        }
    }
    private void setImage(String imageUrl, String imageName,String imageAdress,String imageCity ){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.image_description);
        name.setText(imageName);
        TextView adress = findViewById(R.id.image_adress);
        adress.setText(imageAdress);
        TextView city = findViewById(R.id.image_city);
        city.setText(imageCity);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
