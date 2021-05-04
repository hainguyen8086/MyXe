package com.doancuoiky.myxe.model;

public class LocationPoint {
    double lat;
    double lng;
    String name;
    String fullAdress;
    public LocationPoint(){

    }

    public LocationPoint(double lat, double lng, String name, String fullAdress) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
        this.fullAdress = fullAdress;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullAdress() {
        return fullAdress;
    }

    public void setFullAdress(String fullAdress) {
        this.fullAdress = fullAdress;
    }
}
