/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilicom.csv;

/**
 *
 * @author dhiraj
 */
public class ADTGPSDetails {
    String longtitude;	
    String latitude; 
    String altitude; 
    String dimension;	
    String speed;
    String climb;
    String bearing;
    String distance;
    String RRSI;
    String CINR;
    String RF;	

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getClimb() {
        return climb;
    }

    public void setClimb(String climb) {
        this.climb = climb;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRRSI() {
        return RRSI;
    }

    public void setRRSI(String RRSI) {
        this.RRSI = RRSI;
    }

    public String getCINR() {
        return CINR;
    }

    public void setCINR(String CINR) {
        this.CINR = CINR;
    }

    public String getRF() {
        return RF;
    }

    public void setRF(String RF) {
        this.RF = RF;
    }
  
}
