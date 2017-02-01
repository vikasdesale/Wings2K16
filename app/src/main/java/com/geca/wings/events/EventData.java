package com.geca.wings.events;

/**
 * Created by Dell on 1/18/2016.
 */

public class EventData {
    private String mText1;
    private int image;

    EventData(String text1,int v){
        mText1 = text1;
        image= v;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int mText2) {
        this.image = mText2;
    }
}
