package com.life.shelter.people.homeless;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class CountryActivity extends AppCompatActivity {
    private AdView adView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);




        ImageView img1= (ImageView) findViewById(R.id.org_image1);
        ImageView img2= (ImageView) findViewById(R.id.org_image2);
        ImageView img3= (ImageView) findViewById(R.id.org_image3);
        ImageView img4= (ImageView) findViewById(R.id.org_image4);
        ImageView img5= (ImageView) findViewById(R.id.org_image5);
        TextView txt1= (TextView) findViewById(R.id.org_name1);
        TextView txt2= (TextView) findViewById(R.id.org_name2);
        TextView txt3= (TextView) findViewById(R.id.org_name3);
        TextView txt4= (TextView) findViewById(R.id.org_name4);
        TextView txt5= (TextView) findViewById(R.id.org_name5);
        TextView webSite1 = (TextView) findViewById(R.id.website1);
        TextView facebook1 = (TextView) findViewById(R.id.website1_2);
        TextView donate1 = (TextView) findViewById(R.id.website1_3);
        TextView webSite2 = (TextView) findViewById(R.id.website2);
        TextView facebook2 = (TextView) findViewById(R.id.website2_2);
        TextView donate2 = (TextView) findViewById(R.id.website2_3);
        TextView webSite3 = (TextView) findViewById(R.id.website3);
        TextView facebook3 = (TextView) findViewById(R.id.website3_2);
        TextView donate3 = (TextView) findViewById(R.id.website3_3);
        TextView webSite4 = (TextView) findViewById(R.id.website4);
        TextView facebook4 = (TextView) findViewById(R.id.website4_2);
        TextView donate4 = (TextView) findViewById(R.id.website4_3);
        TextView webSite5 = (TextView) findViewById(R.id.website5);
        TextView facebook5 = (TextView) findViewById(R.id.website5_2);
        TextView donate5 = (TextView) findViewById(R.id.website5_3);


        Intent actIntent = getIntent();
        String movedCountryName2 = actIntent.getExtras().getString(CharitableOrganizations.COUNTRY_NAME);





        if (movedCountryName2.equals("Algeria")){
            img1.setImageResource(R.drawable.ferdustunisia);
            txt1.setText(R.string.alfirdaws_association);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_website,Toast.LENGTH_LONG).show();
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/Resala.org?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }







        else if (movedCountryName2.equals("Egypt")){
            img1.setImageResource(R.drawable.resala);
            txt1.setText(R.string.risala_association);
            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://resala.org/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/Resala.org?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://resala.org/ar/donation"));
                    startActivity(intentI);
                }
            });


            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

            img2.setImageResource(R.drawable.caritasegy);
            txt2.setText(R.string.caritas_egypt_association);
            webSite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://caritas-egypt.org/"));
                    startActivity(intentI);
                }
            });

            facebook2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/%D8%AC%D9%85%D8%B9%D9%8A%D8%A9-%D9%83%D8%A7%D8%B1%D9%8A%D8%AA%D8%A7%D8%B3-%D9%85%D8%B5%D8%B1-199516580061017/?hc_location=ufi"));
                    startActivity(intentI);
                }
            });


            donate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://caritas-egypt.org/ar/get-involved/#donate-now"));
                    startActivity(intentI);
                }
            });


            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

            img3.setImageResource(R.drawable.maana);
            txt3.setText(R.string.to_save_a_human);
            webSite3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.darma3ana.org/"));
                    startActivity(intentI);
                }
            });

            facebook3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/togethertosaveahuman/?hc_ref=ARSHgJxR-fw4D0f0nic7LXlEqN8rz8yB_3qr16MuslsolssvQStdEGIl18dyPCSPE-I&fref=nf&__xts__[0]=68.ARDbTKp1Jr1z9I0E3tAYwqo8Dhu0y0ZDpObPW26XcsrT8lUosCH7r5ExBUrMxivrTYOFtOUfCf8WiKwyTlpixyW8cVcJrM01zJxy-AZx_x3umMYrZnBnTWXVkRtX7Tr9PdLv8FfZtOSY8LGvkuZv0cbdmeoqZJUmKDHRYFAIg6ht6p9Ums1Z6A&__tn__=kC-R"));
                    startActivity(intentI);
                }
            });


            donate3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),  R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });



            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

            img4.setImageResource(R.drawable.basmaeyg);
            txt4.setText(R.string.basma_for_accommodation);
            webSite4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_website,Toast.LENGTH_LONG).show();
                }
            });

            facebook4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DarBasma1/?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });


            //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

            img5.setImageResource(R.mipmap.icon);
            txt5.setText(R.string.hamza_khatib_charity_association);
            webSite5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hamzaelkhateeb.com/default_ar.aspx"));
                    startActivity(intentI);
                }
            });

            facebook5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/%D9%85%D8%A4%D8%B3%D8%B3%D8%A9-%D8%AD%D9%85%D8%B2%D8%A9-%D8%A7%D9%84%D8%AE%D8%B7%D9%8A%D8%A8-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1%D9%8A%D8%A9-133729323459718/"));
                    startActivity(intentI);
                }
            });


            donate5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse(" http://www.hamzaelkhateeb.com/default_ar.aspx?id=67&Name=%D8%A7%D9%84%D8%AA%D9%80%D9%80%D8%A8%D9%80%D9%80%D9%80%D9%80%D9%80%D9%80%D8%B1%D8%B9"));
                    startActivity(intentI);
                }
            });

        }










        else if (movedCountryName2.equals("Jordon")){
            img1.setImageResource(R.drawable.molhemjordan);
            txt1.setText(R.string.volunteer_malahum_association);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://molhamteam.com/en"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/molhamteam/"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://molhamteam.com/donate"));
                    startActivity(intentI);

                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }







        else if (movedCountryName2.equals("Kuwait")){
            img1.setImageResource(R.drawable.rahmaintkuwait);
            txt1.setText(R.string.alrahmat_alealamia_association);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.khaironline.net/default.aspx"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/khaironline.net?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.khaironline.net/Zakah/Zakah.aspx"));
                    startActivity(intentI);

                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }






        else if (movedCountryName2.equals("Lebanon")){
            img1.setImageResource(R.drawable.ihrelieflebanono);
            txt1.setText(R.string.international_humanitarian_relief);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ihrelief.org/ar/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/ihrelief/?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ihrelief.org/ar/donate/"));
                    startActivity(intentI);

                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }








        else if (movedCountryName2.equals("Libya")){
            img1.setImageResource(R.drawable.nasaaemlibya);
            txt1.setText(R.string.nasayim_alkhayr_alkhayria_organization);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_website,Toast.LENGTH_LONG).show();
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/%D9%85%D9%86%D8%B8%D9%85%D8%A9-%D9%86%D8%B3%D8%A7%D8%A6%D9%85-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1-%D9%84%D9%84%D8%A3%D8%B9%D9%85%D8%A7%D9%84-%D8%A7%D9%84%D8%AE%D9%8A%D8%B1%D9%8A%D8%A9-2096732283937140/?_rdc=2&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });





            img2.setImageResource(R.drawable.kolonalibya);
            txt2.setText(R.string.kolna_shabab_libia_organization);


            webSite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_website,Toast.LENGTH_LONG).show();

                }
            });

            facebook2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/wayLibya/"));
                    startActivity(intentI);
                }
            });


            donate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });




            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }




        else if (movedCountryName2.equals("Morocco")){
            img1.setImageResource(R.drawable.ataamorocco);
            txt1.setText(R.string.eata_alkhayria_association);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ataa.ma/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/AtaaCF?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }








        else if (movedCountryName2.equals("Qatar")){
            img1.setImageResource(R.drawable.charityqatar);
            txt1.setText(R.string.qatar_alkhayria);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.qcharity.org/ar/qa/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/QCharity?ref=ts&_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });



            img2.setImageResource(R.drawable.eidqatar);
            txt2.setText(R.string.eyd_alkhayria);


            webSite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eidcharity.net/"));
                    startActivity(intentI);
                }
            });

            facebook2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/Eidcharityqatar?fref=nf&_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }








        else if (movedCountryName2.equals("Saudi Arabia")){
            img1.setImageResource(R.drawable.umalqurasa);
            txt1.setText(R.string.um_el_qura_association_for_relief_and_development);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amalquraa.ml/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/amalquraa?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation,Toast.LENGTH_LONG).show();
                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }





        else if (movedCountryName2.equals("Syria")) {
            img1.setImageResource(R.drawable.humancaresyria);
            txt1.setText(R.string.humanitarian_care_association);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.humancaresyria.org/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/HumanCareSyria?fref=pb&hc_location=profile_browser&_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.humancaresyria.org/donate/"));
                    startActivity(intentI);
                }
            });


            img2.setImageResource(R.drawable.ataasyria);
            txt2.setText(R.string.eata_alkhayria_association);
            webSite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ataarelief.org/"));
                    startActivity(intentI);
                }
            });

            facebook2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/AtaaRelief?hc_location=stream&_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation, Toast.LENGTH_LONG).show();
                }
            });


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }







        else if (movedCountryName2.equals("Tunisia")){
            img1.setImageResource(R.drawable.safaxtunisia);
            txt1.setText(R.string.safaqis_alkhayria);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sfaxcharity.org/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/sfaxcharity?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sfaxcharity.org/article-31-%D8%A7%D8%AA%D8%A8%D8%B1%D8%B9"));
                    startActivity(intentI);
                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }










        else if (movedCountryName2.equals("Turkey")) {
            img1.setImageResource(R.drawable.pacturkey);
            txt1.setText(R.string.doctors_across_continents);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pac-turkey.org/"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/PACTurkey/timeline?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), R.string.no_onation, Toast.LENGTH_LONG).show();
                }
            });



            img2.setImageResource(R.drawable.drcturkey);
            txt2.setText(R.string.programs_of_the_danish_refugee_council_in_turkey);
            webSite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drc.ngo/"));
                    startActivity(intentI);
                }
            });

            facebook2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/DRCTurkey/?ref=ts&fref=ts&_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drc.ngo/donate?donate-amount=100&cid=23015&freq=0"));
                    startActivity(intentI);
                }
            });


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }



        else if (movedCountryName2.equals("United Arab Emirates")){
            img1.setImageResource(R.drawable.daralbiruae);
            txt1.setText(R.string.dar_albar_association);


            webSite1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.daralber.ae/ar/home"));
                    startActivity(intentI);
                }
            });

            facebook1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/daralbersociety/?_rdc=1&_rdr"));
                    startActivity(intentI);
                }
            });


            donate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentI = new Intent(Intent.ACTION_VIEW, Uri.parse("https://daralber.ae/cms/ar/home#"));
                    startActivity(intentI);
                }
            });

            img2.setVisibility(View.INVISIBLE);
            txt2.setVisibility(View.INVISIBLE);
            webSite2.setVisibility(View.INVISIBLE);
            facebook2.setVisibility(View.INVISIBLE);
            donate2.setVisibility(View.INVISIBLE);


            img3.setVisibility(View.INVISIBLE);
            txt3.setVisibility(View.INVISIBLE);
            webSite3.setVisibility(View.INVISIBLE);
            facebook3.setVisibility(View.INVISIBLE);
            donate3.setVisibility(View.INVISIBLE);


            img4.setVisibility(View.INVISIBLE);
            txt4.setVisibility(View.INVISIBLE);
            webSite4.setVisibility(View.INVISIBLE);
            facebook4.setVisibility(View.INVISIBLE);
            donate4.setVisibility(View.INVISIBLE);


            img5.setVisibility(View.INVISIBLE);
            txt5.setVisibility(View.INVISIBLE);
            webSite5.setVisibility(View.INVISIBLE);
            facebook5.setVisibility(View.INVISIBLE);
            donate5.setVisibility(View.INVISIBLE);
        }



    }
}

