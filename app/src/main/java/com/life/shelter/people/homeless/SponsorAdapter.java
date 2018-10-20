package com.life.shelter.people.homeless;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by yasser on 9/19/2018.
 */

public class SponsorAdapter extends ArrayAdapter<Sponsor> {
    public SponsorAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Sponsor> sponsors) {
        super(context, resource, sponsors);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_supporter,parent,false
            );

            Sponsor currentSponsor =getItem(position);
            TextView sponsorNameTextView=listItemView.findViewById(R.id.sponser);
            sponsorNameTextView.setText(currentSponsor.getSponsorName());
            ImageView imageView=listItemView.findViewById(R.id.image);
            imageView.setImageResource(currentSponsor.getmImageID());
        }
        return listItemView;
    }
}
