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
public class FlyCoordinates {
    public final double latitude;
    public final double longitude;

    public FlyCoordinates(double lat, double lon) {
        latitude = lat;
        longitude = lon;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    
    
}