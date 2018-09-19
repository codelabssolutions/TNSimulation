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
public class RouteDetail {
    String componentName;
    Double xPoint;
    Double yPoint;
    String componentText;
    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public Double getxPoint() {
        return xPoint;
    }

    public void setxPoint(Double xPoint) {
        this.xPoint = xPoint;
    }

    public Double getyPoint() {
        return yPoint;
    }

    public void setyPoint(Double yPoint) {
        this.yPoint = yPoint;
    }

    public String getComponentText() {
        return componentText;
    }

    public void setComponentText(String componentText) {
        this.componentText = componentText;
    }
     
    @Override
    public String toString() {
        return  "componentName=" + componentName + ", xPoint=" + xPoint + ", yPoint=" + yPoint ;
    }
 
}
