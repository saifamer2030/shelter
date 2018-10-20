package com.life.shelter.people.homeless;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class CharitableOrganizations extends ListActivity
{
    // variable to select country (mohammad alamouri - Charitable)
    final public static String COUNTRY_NAME = "ABC";
    public String countryNameValue;


    private String[] listview_names =  {"Algeria","Egypt","Jordon",
            "Kuwait", "Lebanon","Libya","Morocco",
            "Qatar","Saudi Arabia","Syria","Tunisia",
            "Turkey", "United Arab Emirates"};
    static Context mcontext;

    private static int[] listview_images =
            {R.drawable.algeria, R.drawable.egypt, R.drawable.jordan,
                    R.drawable.kuwiat, R.drawable.lebanon, R.drawable.libya, R.drawable.morocco,
                    R.drawable.qatar, R.drawable.saudiarabia, R.drawable.syria, R.drawable.tunisia,
                    R.drawable.turkey, R.drawable.unitedarabemirates};

    private ListView lv;
    private static ArrayList<String> array_sort;
    private static ArrayList<Integer> image_sort;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charitable_organizations);
        lv = (ListView) findViewById(android.R.id.list);
        array_sort=new ArrayList<String> (Arrays.asList(listview_names));
        image_sort=new ArrayList<Integer>();
        for (int index = 0; index < listview_images.length; index++)
        {
            image_sort.add(listview_images[index]);
        }
        setListAdapter(new bsAdapter(this));

        lv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3)
            {
                String selectedCountry = (String) arg0.getItemAtPosition(position);
                //    Toast.makeText(getApplicationContext(), array_sort.get(position),
                //            Toast.LENGTH_SHORT).show();

                countryNameValue = selectedCountry;





                //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
                // Mohammad Alamouri - Charitable Team
                // to open the selected country to see the charitable organizations.
                // 0 means "Algeria"
                if (position == 0) {
                    Intent algeriaIntent = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    algeriaIntent.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(algeriaIntent);
                }


                else if (position == 1) {
                    Intent egyptIntent = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    egyptIntent.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(egyptIntent);
                }



                else if (position == 2) {
                    Intent jordanIntent = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    jordanIntent.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(jordanIntent);
                }



                else if (position == 3) {
                    Intent kuwiatInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    kuwiatInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(kuwiatInt);
                }

                else if (position == 4) {
                    Intent lebanonInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    lebanonInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(lebanonInt);
                }


                else if (position == 5) {
                    Intent libyaInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    libyaInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(libyaInt);
                }

                else if (position == 6) {
                    Intent moroccoInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    moroccoInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(moroccoInt);
                }

                else if (position == 7) {
                    Intent qatarInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    qatarInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(qatarInt);
                }

                else if (position == 8) {
                    Intent saInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    saInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(saInt);
                }


                else if (position == 9) {
                    Intent syriaInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    syriaInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(syriaInt);
                }


                else if (position == 10) {
                    Intent tunisiaInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    tunisiaInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(tunisiaInt);
                }


                else if (position == 11) {
                    Intent turkeyInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    turkeyInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(turkeyInt);
                }


                else if (position == 12) {
                    Intent uaeInt = new Intent(CharitableOrganizations.this, CountryActivity.class);
                    uaeInt.putExtra(COUNTRY_NAME, countryNameValue);
                    startActivity(uaeInt);
                }





            }
        });
    }
    public static class bsAdapter extends BaseAdapter
    {
        Activity cntx;
        public bsAdapter(Activity context)
        {
            // TODO Auto-generated constructor stub
            this.cntx=context;
        }

        public int getCount()
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }

        public Object getItem(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.get(position);
        }

        public long getItemId(int position)
        {
            // TODO Auto-generated method stub
            return array_sort.size();
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            View row=null;
            LayoutInflater inflater=cntx.getLayoutInflater();
            row=inflater.inflate(R.layout.list_item, null);
            TextView tv = (TextView) row.findViewById(R.id.title);
            ImageView im = (ImageView) row.findViewById(R.id.imageview);
            tv.setText(array_sort.get(position));

            im.setImageBitmap(getRoundedShape(decodeFile(cntx, listview_images[position]),200));

            return row;
        }

        public static Bitmap decodeFile(Context context,int resId) {
            try {
// decode image size
                mcontext=context;
                BitmapFactory.Options o = new BitmapFactory.Options();
                o.inJustDecodeBounds = true;
                BitmapFactory.decodeResource(mcontext.getResources(), resId, o);
// Find the correct scale value. It should be the power of 2.
                final int REQUIRED_SIZE = 200;
                int width_tmp = o.outWidth, height_tmp = o.outHeight;
                int scale = 1;
                while (true)
                {
                    if (width_tmp / 2 < REQUIRED_SIZE
                            || height_tmp / 2 < REQUIRED_SIZE)
                        break;
                    width_tmp /= 2;
                    height_tmp /= 2;
                    scale++;
                }
// decode with inSampleSize
                BitmapFactory.Options o2 = new BitmapFactory.Options();
                o2.inSampleSize = scale;
                return BitmapFactory.decodeResource(mcontext.getResources(), resId, o2);
            } catch (Exception e) {
            }
            return null;
        }
    }
    public static Bitmap getRoundedShape(Bitmap scaleBitmapImage,int width) {
        // TODO Auto-generated method stub
        int targetWidth = width;
        int targetHeight = width;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
                targetHeight,Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth),
                        ((float) targetHeight)) / 2),
                Path.Direction.CCW);
        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap,
                new Rect(0, 0, sourceBitmap.getWidth(),
                        sourceBitmap.getHeight()),
                new Rect(0, 0, targetWidth,
                        targetHeight), null);
        return targetBitmap;
    }
}
