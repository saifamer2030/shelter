package com.life.shelter.people.homeless;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class XmlTeam extends ListActivity {
    // names
    private String[] listview_names =  {"Slimane Salim","Ben Djamaa Ibrahim"
            ,"Haron Al-kahtani","Samah Ahmad Makki","Doaa Saleh",
            "Duaa Alqurashi",
            "Mustafa HagMusa","Reham Mahmoud" };
    //emailes
    private String[] listview_emails = {"shara.admo@gmail.com",
            "ibrahimbendjamaa@gmail.com ",
            "harown12@gmail.com","samahmakki91@gmail.com","doaalgendy@gmail.com","Duaaalqurashig@gmail.com",
            "abuelsafe@hotmail.com","ph_a_r@yahoo.com"};
    //linkedin accounts
    private String[] listview_linkedin = {"https://www.linkedin.com/in/mdeveloppeur",
            "https://www.linkedin.com/in/ibrahim-bendjamaa-5a3930168/",


            "https://www.linkedin.com/in/haron-al-kahtani-017881169","https://www.linkedin.com/in/samahmakki",
            "https://www.linkedin.com/in/doaa-saleh-519a44170/","https://www.linkedin.com/in/duaa-alqurashi-3bb12616a/",
            "https://www.linkedin.com/in/mustafa-hag-musa-scada-eng/",
            //wrong link with reham likedin
            ""
    };

    static Context mcontext;
    TextView textView;

    // images
    private static int[] listview_images =
            {
                    R.drawable.image1a,R.drawable.image3a,R.drawable.image6,
                    R.drawable.image7,R.drawable.image8,R.drawable.image11,
                    R.drawable.image19,R.drawable.image22};


    private ListView lv;
    private static ArrayList<String> array_sort;
    private static ArrayList<String> array_sort1;
    private static ArrayList<String> array_sort2;

    private static ArrayList<Integer> image_sort;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2act);
        lv = (ListView) findViewById(android.R.id.list);

        array_sort=new ArrayList<String> (Arrays.asList(listview_names));
        array_sort1=new ArrayList<String> (Arrays.asList(listview_emails));
        array_sort2=new ArrayList<String> (Arrays.asList(listview_linkedin));

        image_sort=new ArrayList<Integer>();
        for (int index = 0; index < listview_images.length; index++)
        {
            image_sort.add(listview_images[index]);
        }
        setListAdapter(new XmlTeam.bsAdapter(this));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3)
            {

                Intent browserIntent = new Intent(getApplicationContext(),WebViewActivity.class);
                browserIntent.putExtra("url",array_sort2.get(position));
                startActivity(browserIntent);
            }
        });

        textView = (TextView) findViewById(R.id.message);
        textView.setText("فريق Xml");


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
            TextView tv1 = (TextView) row.findViewById(R.id.email);

            ImageView im = (ImageView) row.findViewById(R.id.imageview);
            tv.setText(array_sort.get(position));
//            tv1.setText(array_sort1.get(position));

            im.setImageBitmap(getRoundedShape(decodeFile(cntx, listview_images[position]),200));

            return row;
        }

        public static Bitmap decodeFile(Context context, int resId) {
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
