/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilicom.csv;

import com.mobilicom.main.Line;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dhiraj
 */
public class RouteDrawing {
    List<RouteDetail> routeDetails;  
    ArrayList<Line> lines ;

    public List<RouteDetail> getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(List<RouteDetail> routeDetails) {
        this.routeDetails = routeDetails;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }
    
}
