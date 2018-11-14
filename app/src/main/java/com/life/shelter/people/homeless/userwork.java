package com.life.shelter.people.homeless;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class userwork extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;
    private DatabaseReference databaseTramp;
    private DatabaseReference databaseReg;
    String type,country;
    String userId;
    ListView listViewTrampA;
    List<HomeFirebaseClass> trampList;
    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userwork);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // user id from adepter
        userId = getIntent().getStringExtra("userid");
        //Toast.makeText(userwork.this, "+/+ "+userId, Toast.LENGTH_LONG).show();

        mAuth = FirebaseAuth.getInstance();


        databaseTramp= FirebaseDatabase.getInstance().getReference("trampoos");
        mStorageRef = FirebaseStorage.getInstance().getReference("trrrrr");

        listViewTrampA= (ListView)findViewById(R.id.list_view_tramp_user);
        trampList=new ArrayList<>();
    }


    @Override
    protected void onStart() {
        super.onStart();
        getRegData();

    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null) {
            return true;
        } else {
            return false;
        }
    }
    private void getRegData() {
////import data of country and tope
        databaseReg = FirebaseDatabase.getInstance().getReference("reg_data");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                type = dataSnapshot.child(userId).child("ctype").getValue(String.class);
                country = dataSnapshot.child(userId).child("ccountry").getValue(String.class);
                maketable();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        };
        databaseReg .addValueEventListener(postListener);
    }
    private void maketable() {

        if (isNetworkConnected()) {
            if(country != null &&  type != null) {
                databaseTramp.child(country).child(type).child("users").child(userId).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        trampList.clear();

                        //for (DataSnapshot userid : dataSnapshot.getChildren()) {

                        //for (DataSnapshot userdataSnapshot : userid.getChildren()) {
                        for (DataSnapshot userdataSnapshot : dataSnapshot.getChildren()) {

                            String cId = userdataSnapshot.child("cId").getValue(String.class);
                            String hname = userdataSnapshot.child("cName").getValue(String.class);
                            String haddress = userdataSnapshot.child("cAddress").getValue(String.class);
                            String hcity = userdataSnapshot.child("cCity").getValue(String.class);
                            String huri = userdataSnapshot.child("cUri").getValue(String.class);
                            String huseruri = userdataSnapshot.child("userUri").getValue(String.class);
                            String husername = userdataSnapshot.child("username").getValue(String.class);
                            String hpdate = userdataSnapshot.child("pdate").getValue(String.class);
                            String huserid = userdataSnapshot.child("userId").getValue(String.class);
                            Boolean checked = userdataSnapshot.child("checked").getValue(Boolean.class);
                            String organizationId = userdataSnapshot.child("organizationId").getValue(String.class);
                            String organizationName = userdataSnapshot.child("organizationName").getValue(String.class);

                            HomeFirebaseClass hometramp = new HomeFirebaseClass(cId, hname, haddress, hcity, huri,
                                    huseruri, husername, hpdate,huserid, checked,organizationId,organizationName);
                            //trampList.add(hometramp);
                            trampList.add(0, hometramp);
                        }
                        // }
                        //}
                        TrampHomeAdapter adapter = new TrampHomeAdapter(userwork.this, trampList);
                        //adapter.notifyDataSetChanged();
                        listViewTrampA.setAdapter(adapter);

                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            } } else {
            Toast.makeText(userwork.this, R.string.check_the_network, Toast.LENGTH_LONG).show();
        }

    }
}
