package com.life.shelter.people.homeless;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.life.shelter.people.homeless.recycleadapter.listadapter;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by AHMED MAGDY on 9/15/2018.
 */

public class TrampHomeAdapter extends ArrayAdapter<HomeFirebaseClass> implements Filterable {

    private Activity context;
    private List<HomeFirebaseClass> trampList;
    private List<HomeFirebaseClass> mSearchList;
    private String a1, a2;
    String type,country;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReg;
    ImageView aTrampPhoto;
    ShareDialog shareDialog;
    CallbackManager callbackManager;

    public TrampHomeAdapter(Activity context, List<HomeFirebaseClass> trampList) {
        super(context, R.layout.list_layout_home, trampList);
        this.context = context;
        this.trampList = trampList;
    }

    @SuppressLint("WrongConstant")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        final View listViewItem = inflater.inflate(R.layout.list_layout_home, null, true);
        final HomeFirebaseClass hometramp = trampList.get(position);

        final TextView aTrampName = (TextView) listViewItem.findViewById(R.id.tramp_name);
        final TextView aTrampAddress = (TextView) listViewItem.findViewById(R.id.tramp_address);
        final TextView aTrampCity = (TextView) listViewItem.findViewById(R.id.tramp_city);

        shareDialog = new ShareDialog((Activity) context);
        callbackManager = CallbackManager.Factory.create();

        // to copy  text
        aTrampName.setTextIsSelectable(true);
        aTrampAddress.setTextIsSelectable(true);
        aTrampCity.setTextIsSelectable(true);


        aTrampPhoto = (ImageView) listViewItem.findViewById(R.id.tramp_photo);
        final ImageView aUserPhoto = (ImageView) listViewItem.findViewById(R.id.user_name_logo_list);

        final TextView aUserName = (TextView) listViewItem.findViewById(R.id.user_name_list);
        final TextView aDate = (TextView) listViewItem.findViewById(R.id.date_list);
        final ImageView asharelogo = (ImageView) listViewItem.findViewById(R.id.share_logo);
        final ImageView afacelogo = (ImageView) listViewItem.findViewById(R.id.fac_logo);
        final ImageView atwitterlogo = (ImageView) listViewItem.findViewById(R.id.tweeter_logo);

//////////////////////////////////////////////////////////////////
        aUserName.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent mIntent = new Intent(context, ProfileActivity.class);
                context.startActivity(mIntent);
                return true;
            }
        });
        aUserPhoto.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent mIntent = new Intent(context, ProfileActivity.class);
                context.startActivity(mIntent);
                return true;
            }
        });
        /***go to user page***/
        aUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFirebaseClass hometramp = trampList.get(position);
                Intent uIntent = new Intent(context, userwork.class);
                uIntent.putExtra("userid",  hometramp.getUserId());
                uIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(uIntent);
                // context.finish();
            }
        });
        aUserPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFirebaseClass hometramp = trampList.get(position);
                Intent uIntent = new Intent(context, userwork.class);
                uIntent.putExtra("userid",  hometramp.getUserId());
                uIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(uIntent);
                // context.finish();
            }
        });

        aTrampPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFirebaseClass hometramp = trampList.get(position);
                a1=hometramp.getcUri();

                Intent uIntent = new Intent(context, trampPhotoActivity.class);
                uIntent.putExtra("image_url", a1);
                uIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(uIntent);

            }
        });
        /////////////////////////////

        afacelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1=hometramp.getcUri();

                String b1=hometramp.getcName();
                String b2=hometramp.getcAddress();
                String b3=hometramp.getcCity();
                HomeFirebaseClass hometramp = trampList.get(position);
                if (a1!=null)
                {
                    if (ShareDialog.canShow(ShareLinkContent.class)) {
                        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                .setImageUrl(Uri.parse(a1))
                                .setContentUrl(Uri.parse(a1))


                                .setQuote("حالة تحتاج الي مساعدة"+"\n" +b1 + "\n" +
                                        b2 +"\n" +
                                        b3)
                                .build();
                        shareDialog.show(linkContent);
                    }
                }
                else {
                    if (ShareDialog.canShow(ShareLinkContent.class)) {
                        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                // .setImageUrl(Uri.parse(mylist.get(pos).getDownloadimgurl()))
                                .setContentUrl(Uri.parse("https://goo.gl/images/Ajo63W"))


                                .setQuote("حالة تحتاج الي مساعدة"+"\n" +b1 + "\n" +
                                        b2 + "\n" +
                                        b3)
                                .build();
                        shareDialog.show(linkContent);
                    }

                }



            }


        });


        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
/**
        atwitterlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFirebaseClass hometramp = trampList.get(position);
                a1=hometramp.getcUri();
                if (a1!=null) {
                    new DownloadImage().execute(a1);
                    File path = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                    File file = new File(path, "DemoPicture.jpg");
                    String imageFullPath = file.getAbsolutePath();

                    TweetComposer.Builder builder = new TweetComposer.Builder(context)
                            .text("حالة تحتاج الي مساعدة" + "\n"
                                    + hometramp.getcName()+ "\n"
                                    + hometramp.getcAddress()+ "\n"
                                    + hometramp.getcCity())//any sharing text here
                            .image(Uri.parse(imageFullPath));
                    builder.show();

                } else {

                    String tweetUrl = "https://twitter.com/intent/tweet?text="
                            + "حالة تحتاج الي مساعدة" + "\n"
                            + hometramp.getcName()+ "\n"
                            + hometramp.getcAddress()+ "\n"
                            + hometramp.getcCity()+ "\n"
                            + "&url="
                            + Uri.parse("https://goo.gl/images/Ajo63W");
                    Uri uri = Uri.parse(tweetUrl);
                    context.startActivity(new Intent(Intent.ACTION_VIEW, uri));

                }
            }
        });**/
        //////////////////


        asharelogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HomeFirebaseClass hometramp = trampList.get(position);
                a1=hometramp.getcUri();

                String b1=hometramp.getcName();
                String b2=hometramp.getcAddress();
                String b3=hometramp.getcCity();
                final String b4= ""+b1+" in "+ b2+", "+b3 +" need your help";

                Glide.with(context)
                        .asBitmap()
                        .load(a1)
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("image/*");
                                // Bitmap resourse;
                                intent.putExtra(Intent.EXTRA_STREAM, getLocationBitmapUri(resource));
                                intent.putExtra(Intent.EXTRA_TEXT, b4 );
                                context.startActivity(Intent.createChooser(intent, "share picture"));
                            }
                        });

            }
        });



///////////////////////////////////////////////////////////////////
        //chech box action
        final CheckBox tasken =(CheckBox)listViewItem.findViewById(R.id.tasken);
        final ImageView goon =(ImageView) listViewItem.findViewById(R.id.go_on);
        // update check box status
        tasken.setChecked(hometramp.getChecked());//normal code retrive status of checkbox from firebase

        if (hometramp.getOrganizationId() != null) {
            if (hometramp.getOrganizationName() != null) {
                tasken.setText(hometramp.getOrganizationName());
            }else{tasken.setText("Unknown Name");}
            goon.setVisibility(View.VISIBLE);

        }else{ tasken.setText("not housed");
            goon.setVisibility(View.GONE);}
        // check box listener
        tasken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
                getRegData("checkBox", hometramp, isChecked, buttonView, tasken);
            }
        });
        goon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hometramp.getOrganizationId() != null) {
                    String a10=hometramp.getOrganizationId();

                    Intent uIntent = new Intent(context, organizationhome.class);
                    uIntent.putExtra("org_homed", a10);
                    uIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(uIntent);}

            }
        });
        // update check name if not null
        //  if (hometramp.getOrganizationId() == null)
        //    tasken.setText(hometramp.getOrganizationName());

        ///////////////////////////////////////////////////////////////////

        aTrampName.setText(hometramp.getcName());
        aTrampAddress.setText(hometramp.getcAddress());
        aTrampCity.setText(hometramp.getcCity());

        a1=hometramp.getcUri();

        RequestOptions requestOptions = new RequestOptions();
        requestOptions = requestOptions.transforms(new RoundedCorners(16));

        Glide.with(context)
                .load(a1)
                .apply(requestOptions)
                .into(aTrampPhoto);



        aDate.setText(hometramp.getPdate());

        ////////////////////////////////
        a2=hometramp.getUserUri();

        if(a2 != null){
            Glide.with(context)
                    .load(a2)
                    .apply(RequestOptions.circleCropTransform())
                    .into(aUserPhoto);
        }else {
            Glide.with(context)
                    .load("https://firebasestorage.googleapis.com/v0/b/shelter-87aaa.appspot.com/o/user.png?alt=media&token=0a6b51c3-f1ec-4fea-a0eb-a7eaa45875d4")
                    .apply(RequestOptions.circleCropTransform())
                    .into(aUserPhoto);         }

        if(hometramp.getUsername() != null){
            aUserName.setText(hometramp.getUsername());
        }else {

            aUserName.setText("Unknown name");

        }

        // more option button
        ImageView moreOption = listViewItem.findViewById(R.id.more_list);

        // more option click listener
        moreOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Click","More Image ");
                getRegData("more", hometramp, position);
            }
        });
        // end

        return listViewItem;
    }

    private void getRegData(String action, HomeFirebaseClass homeFirebaseClass, int position) {
        getRegData(action, homeFirebaseClass,position, null, null,null);
    }

    private void getRegData(String action, HomeFirebaseClass homeFirebaseClass, Boolean isChecked,
                            CompoundButton buttonView ,TextView tasken) {
        getRegData(action, homeFirebaseClass,0, isChecked, buttonView,tasken);
    }

    private void getRegData(final String action, final HomeFirebaseClass homeFirebaseClass, final int position,
                            final Boolean isChecked, final CompoundButton buttonView, final TextView tasken) {
        ////import data of country and tope
        databaseReg = FirebaseDatabase.getInstance().getReference("reg_data");
        mAuth = FirebaseAuth.getInstance();

        final ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                type = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("ctype").getValue(String.class);
                country = dataSnapshot.child(mAuth.getCurrentUser().getUid()).child("ccountry").getValue(String.class);
                if (action.equals("more")) {
                    showItemDialog(homeFirebaseClass, position);
                } else if (action.equals("checkBox")) {
                    changeCheckBoxStatus(isChecked, homeFirebaseClass, buttonView, tasken);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
            }
        };
        databaseReg .addValueEventListener(postListener);
    }

    private void changeCheckBoxStatus(Boolean isChecked, HomeFirebaseClass homeFirebaseClass, CompoundButton buttonView, TextView tasken) {
        if (!type.equals("Organization")) {
            Toast.makeText(context, "you must be an organization", Toast.LENGTH_LONG).show();
            buttonView.setChecked(false);
            return;
        }

        DatabaseReference databasetramp = FirebaseDatabase.getInstance().getReference("trampoos");
        DatabaseReference databaseHome = FirebaseDatabase.getInstance().getReference("homedb");

        // update check box status
        homeFirebaseClass.setChecked(isChecked);
        ////////////////////////////////////////////
        if (isChecked) {
            FirebaseUser user = mAuth.getCurrentUser();

            homeFirebaseClass.setOrganizationId(mAuth.getCurrentUser().getUid());

            if(user.getDisplayName() != null){
                tasken.setText(user.getDisplayName());
                homeFirebaseClass.setOrganizationName(user.getDisplayName());
            } else {
                tasken.setText("Unknown name");
                homeFirebaseClass.setOrganizationName(null);
            }
            // update database
            databasetramp.child(country).child("Organization")
                    .child("users").child(mAuth.getCurrentUser().getUid())
                    .child(homeFirebaseClass.getcId()).setValue(homeFirebaseClass);
            // update database
            databasetramp.child(country).child("Individual")
                    .child("users").child(homeFirebaseClass.getUserId())
                    .child(homeFirebaseClass.getcId()).setValue(homeFirebaseClass);
        } else {
            homeFirebaseClass.setOrganizationId(null);
            homeFirebaseClass.setOrganizationName(null);

            // update database
            databasetramp.child(country).child("Individual")
                    .child("users").child(homeFirebaseClass.getUserId())
                    .child(homeFirebaseClass.getcId()).setValue(homeFirebaseClass);

            databasetramp.child(country).child("Organization")
                    .child("users").child(mAuth.getCurrentUser().getUid())
                    .child(homeFirebaseClass.getcId()).removeValue();
        }

        // update check box status in home database
        databaseHome.child(country)
                .child(homeFirebaseClass.getcId())
                .setValue(homeFirebaseClass);
    }

    private void showItemDialog(final HomeFirebaseClass item, int position) {
        final Dialog dialog = new Dialog(context);
        final int itemIndex = position;
        String userId = mAuth.getCurrentUser().getUid();
        final DatabaseReference databaseTramp = FirebaseDatabase.getInstance().getReference("trampoos")
                .child(country)
                .child(type)
                .child("users")
                .child(userId);
        final DatabaseReference databaseHome = FirebaseDatabase.getInstance().getReference("homedb")
                .child(country);

        // can edit or delete it
        if (item.isOwner(userId)) {
            if (item.getOrganizationId() == null) {
                dialog.setContentView(R.layout.delete_edit_dialog);

                Button edit = dialog.findViewById(R.id.edit_button_dialog);
                Button delete = dialog.findViewById(R.id.delete_button_dialog);
                Button close = dialog.findViewById(R.id.close_button_dialog);

                // update data
                edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, EditDataActivity.class);
                        intent.putExtra("data", item);
                        context.startActivity(intent);
                    }
                });
                // remove data
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        databaseTramp.child(item.getcId()).removeValue();
                        databaseHome.child(item.getcId()).removeValue();

                        trampList.remove(itemIndex);

                        Intent intent = new Intent(context, home.class);
                        context.startActivity(intent);

                        dialog.dismiss();

                        Log.v("Dialog", "Deleted item!.");
                    }
                });

                // close dialog
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.setCanceledOnTouchOutside(false);
                // show dialog view
                dialog.show();
            }else{Toast.makeText(context, "tramp is housed", Toast.LENGTH_LONG).show();}

        } else
            Log.v("Dialog","Not Owner!.");
        // Toast.makeText(context, "لست صاحب المنشور .. لايمكنك تعديله", Toast.LENGTH_LONG).show();
    }

    private Uri getLocationBitmapUri(Bitmap bmp){
        Uri BmpUri= null;
        try {
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),"share picture_"+System.currentTimeMillis()+".jpeg");
            FileOutputStream out= new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG,90,out);
            out.close();
            BmpUri=Uri.fromFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }return BmpUri;

    }

    @Override
    public int getCount() {
        return trampList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults resultsFilter = new FilterResults();
                final List<HomeFirebaseClass> resultsList = new ArrayList<>();
                if (mSearchList == null)
                    mSearchList = trampList;
                if (constraint != null) {
                    if (mSearchList != null && mSearchList.size() > 0) {
                        for (final HomeFirebaseClass tramp : mSearchList) {
                            if (tramp.getcName().toLowerCase()
                                    .contains(constraint.toString()))
                                resultsList.add(tramp);
                        }
                    }
                    resultsFilter.values = resultsList;
                }
                return resultsFilter;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                trampList = (ArrayList<HomeFirebaseClass>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}

