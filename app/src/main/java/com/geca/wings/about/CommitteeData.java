package com.geca.wings.about;

/**
 * Created by Dell on 1/18/2016.
 */

public class CommitteeData {
    private String mText1;
    private int image;
    private String phone,facebook,gmail,pos;
    CommitteeData(String text1, int v, String p, String pho, String fac, String gm){
        mText1 = text1;
        image= v;
        phone=pho;
        facebook=fac;
        gmail=gm;
        pos=p;
    }



    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail =gmail;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPosition() {
        return pos;
    }

    public void setPosition(String pos) {
        this.pos = pos;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int mText2) {
        this.image = mText2;
    }
}
