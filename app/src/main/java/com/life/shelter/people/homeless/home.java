package com.life.shelter.people.homeless;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.app.SearchManager;

import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.life.shelter.people.homeless.Databeas.Product;
import com.life.shelter.people.homeless.recycleadapter.listadapter;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
  //  private RewardedVideoAd mRewardedVideoAd;
    private FirebaseAuth mAuth;
    private StorageReference mStorageRef;
    private DatabaseReference databaseHome;
    private DatabaseReference databaseReg;
    String type, country;
    ListView listViewTramp;
    SearchView searchView;
    ImageView addTrampButton;
    private ProgressBar progressBar;
    List<HomeFirebaseClass> trampList;
    private AdView adView;
   // private InterstitialAd mInterstitialAd;
    long time;
    private InterstitialAd mInterstitial;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        /// ads Admob Saif Amer
     //   mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
       // mRewardedVideoAd.setRewardedVideoAdListener(this);



        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7419949159214590~4023134282");
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId("ca-app-pub-7419949159214590/4249067821");
        mInterstitial.loadAd(new AdRequest.Builder().build());
        /*mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        addTrampButton = (ImageView) findViewById(R.id.add_tramp_h);
        progressBar = (ProgressBar) findViewById(R.id.home_progress_bar);
        mAuth = FirebaseAuth.getInstance();
        databaseHome = FirebaseDatabase.getInstance().getReference("homedb");
        databaseReg = FirebaseDatabase.getInstance().getReference("reg_data");
        mStorageRef = FirebaseStorage.getInstance().getReference("trrrrr");
        listViewTramp = (ListView) findViewById(R.id.list_view_tramp);
        searchView = (SearchView) findViewById(R.id.search);
        trampList = new ArrayList<>();
        listViewTramp.setTextFilterEnabled(true);
        removeFocus();

        addTrampButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent it = new Intent(home.this, trampdata.class);
                startActivity(it);
            }
        });

///////////////////////////////////////////////////////////

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ////////////////////////////////////////////////////////////
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setVisibility(View.VISIBLE);
        getRegData();
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        final String appUrl = "https://play.google.com/store/apps/details?id=com.life.shelter.people.homeless";

        if (id == R.id.nav_account) {

            Intent it = new Intent(home.this, Account.class);
            startActivity(it);
        } else if (id == R.id.nav_about) {
            Intent it = new Intent(home.this, About.class);
            startActivity(it);
        } /*else if (id == R.id.nav_faq) {

            Intent it = new Intent(home.this, FAQ.class);
            startActivity(it);
        }*/ else if (id == R.id.nav_charitable) {

            Intent it = new Intent(home.this, CharitableOrganizations.class);
            startActivity(it);
        } /*else if (id == R.id.nav_supporting) {

            Intent it = new Intent(home.this, Supporting.class);
            startActivity(it);
        } */else if (id == R.id.nav_developers) {

            Intent it = new Intent(home.this, Developers.class);
            startActivity(it);
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, appUrl);
            startActivity(Intent.createChooser(shareIntent, "Share using"));

        } else if (id == R.id.nav_rate) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(home.this);
            dialogBuilder.setTitle(R.string.rate_s);
            dialogBuilder.setMessage(R.string.if_you);
            dialogBuilder.setPositiveButton(R.string.rate_s, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(appUrl));
                    startActivity(i);
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = dialogBuilder.create();
            dialog.show();

        } else if (id == R.id.nav_profile) {

            Intent it = new Intent(home.this, ProfileActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_homed) {
            Intent it = new Intent(home.this, displayOrganizations.class);
            startActivity(it);

        } else if (id == R.id.nav_out) {
            mAuth.getInstance().signOut();
            Intent it = new Intent(home.this, Login.class);
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(it);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    ////////////////////////////////////////////////////////////////////////
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
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                type = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("ctype").getValue(String.class);
                country = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("ccountry").getValue(String.class);
                maketable();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        };
        databaseReg.addValueEventListener(postListener);

    }

    private void maketable() {

        if (isNetworkConnected()) {
            if (country != null && type != null) {


                if (type.equals("Organization")) {
                    addTrampButton.setVisibility(View.GONE);
                } else {
                    addTrampButton.setVisibility(View.VISIBLE);
                }
                //databaseTramp.child(country).child("Individual").child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                databaseHome.child(country).addListenerForSingleValueEvent(new ValueEventListener() {

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
                                    huseruri, husername, hpdate, huserid, checked, organizationId, organizationName);
                            //trampList.add(hometramp);
                            trampList.add(0, hometramp);
                        }
                        // }
                        //}
                        TrampHomeAdapter adapter = new TrampHomeAdapter(home.this, trampList);
                        //adapter.notifyDataSetChanged();
                        listViewTramp.setAdapter(adapter);
                        setupSearchView();
                        progressBar.setVisibility(View.GONE);
                        // listViewTramp.setAdapter(adapter);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

            }
        } else {
            Toast.makeText(home.this, "please check the network connection", Toast.LENGTH_LONG).show();
        }
    }

    private void setupSearchView() {
        searchView.setIconifiedByDefault(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    listViewTramp.clearTextFilter();
                } else {
                    listViewTramp.setFilterText(newText);
                }
                return true;
            }
        });
    }

    private void removeFocus() {
        searchView.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
    }

  /*  @Override
    public void onBackPressed() {


        if (time + 2000 > System.currentTimeMillis()) {

            super.onBackPressed();
        } else {
            Toast.makeText(home.this, "Press Again To Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();

    }*/

   /* private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-7419949159214590/7292584434",
                new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "Please watch the video until the endleas ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(this, "Thanx For Supporting Us", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Toast.makeText(this, "Sorry for not having any video now please try again", Toast.LENGTH_LONG).show();

    }*/

    // Display Interestial ADMOB when User exit App
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // Toast.makeText(appContext, "BAck", Toast.LENGTH_LONG).show();
            AlertDialog.Builder alert = new AlertDialog.Builder(
                    home.this);
            alert.setTitle(getString(R.string.app_name));
            alert.setIcon(R.drawable.ic_exit);
            alert.setMessage(R.string.quit);

            alert.setPositiveButton(R.string.ok,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int whichButton) {
                            if (mInterstitial.isLoaded()) {
                                mInterstitial.show();
                            }
                            finish();
                        }
                    });
            alert.setNegativeButton(R.string.rate_app,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            final String appName = getPackageName();
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW,
                                        Uri.parse("https://play.google.com/store/apps/details?id=com.life.shelter.people.homeless"
                                                + appName)));
                            } catch (android.content.ActivityNotFoundException anfe) {
                                startActivity(new Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse("https://play.google.com/store/apps/details?id=com.life.shelter.people.homeless"
                                                + appName)));
                            }
                        }
                    });
            alert.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    // End code of Display Interestial ADMOB when User exit App


}
