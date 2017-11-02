package com.example.shrad.kiwicommentapplication;

import java.io.Serializable;

/**
 * Created by shrad on 23/10/2017.
 */

public class Information implements Serializable {


    private String name;
    private static String addresss;
    private String phonenumber;
    private String netlink;
    private String id;
    private float ratings;
    private String placeType;

    public Information(String id,String name, String addresss, String phonenumber,String netlink,
                       String placeType,
                       float ratings){
        this.id=id;
        this.name=name;
        this.addresss=addresss;
        this.phonenumber=phonenumber;
        this.netlink=netlink;
        this.placeType=placeType;
        this.ratings=ratings;
    }

    public Information(String id,String name, String addresss){
        this.id=id;
        this.name=name;
        this.addresss=addresss;
    }

    public Information(){
        this.name="StarBucks";
        this.addresss= "Westgate Shopping Centre, 2-20 Fernhill Drive, Auckland 0614";
        this.phonenumber="09-832 8541";
    }


    public static String getAddresss() {
        return addresss;
    }

    public static void setAddresss(String addresss) {
        Information.addresss = addresss;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getNetlink() {
        return netlink;
    }

    public void setNetlink(String netlink) {
        this.netlink = netlink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

