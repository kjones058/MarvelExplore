package starbuzz.hfad.com.marvelexplore;

import android.graphics.Bitmap;


public class Character {

  private boolean mClicked = false;
    private String mName;
    private int mID;
    private String mDescrp;
    private Bitmap mImage;

    public Character(String name, int ID, String descrp, Bitmap image){
        mName = name;
        mID = ID;
        mDescrp = descrp;
        mImage = image;

    }

    public String getCharName(){
        return mName;
    }

    public int getID(){
        return mID;
    }

    public String getDecrp(){
        return mDescrp;
    }

    public Bitmap getImage(){
        return mImage;
    }

    public void gotClicked(){
        mClicked = true;
    }

    public boolean wasClicked(){
        return mClicked;
    }

    public void unClicked(){
        mClicked = false;
    }
}