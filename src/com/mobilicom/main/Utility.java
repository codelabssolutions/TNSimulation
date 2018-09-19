/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilicom.main;

import java.awt.Point;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author dhiraj
 */
public class Utility {
  
    static double z=11.0;
    public static double calcDistance(double x1,double y1,double x2,double y2) {
       return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
    public static Point nearestGCSPoint(Point airfanPoint,List<Point> cgshomelist) {
        double nearestPointDistance=0.0;
        Point nearestCGSPoint=null;
        for(Point point:cgshomelist){
            double distance=Math.sqrt((airfanPoint.getX()-point.getX())*(airfanPoint.getX()-point.getX())+(airfanPoint.getY()-point.getY())*(airfanPoint.getY()-point.getY()));
            //System.out.println(nearestPointDistance+"com.mobilicom.main.Utility.nearestGCSPoint()============="+distance);
            if(nearestPointDistance==0.0){
                 nearestPointDistance=distance;
                 nearestCGSPoint=point;
            } else{
              if(nearestPointDistance>distance){
                   nearestPointDistance=distance;
                   nearestCGSPoint=point;
              }
            }
        }
        return nearestCGSPoint;
    }
    public static String getCGSHomeText(Point point,String text){
     
       return null;
     }
    public static String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);

    }
    //Calculate lon and lat:
    public static double getTile2lon(double x){
     return x/Math.pow(2.0, z) * 360.0-180;
    }
     public static double getTile2lat(int y){
         double n=Math.PI-(2.0-Math.PI*y)/Math.pow(2.0,z);
         return Math.toDegrees(Math.atan(Math.sinh(n)));
    }
}
