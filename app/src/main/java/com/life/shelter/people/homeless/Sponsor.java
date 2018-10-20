package com.life.shelter.people.homeless;

/**
 * Created by yasser on 9/19/2018.
 */

public class Sponsor {
    private String sponsorName;
    private Integer mImageID;

    public Sponsor(String sponsorName, Integer mImageID) {
        this.sponsorName = sponsorName;
        this.mImageID = mImageID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public Integer getmImageID() {
        return mImageID;
    }
}

