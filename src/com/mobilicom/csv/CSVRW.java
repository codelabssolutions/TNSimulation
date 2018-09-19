/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilicom.csv;

import com.mobilicom.main.Line;
import java.awt.geom.Line2D;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class CSVRW {
    private  String SAMPLE_CSV_FILE = "";
    public void saveRouteDetails(List<RouteDetail> routeDetails,String path){
          try {
                SAMPLE_CSV_FILE=path;
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
                String[] strArray = new String[(routeDetails.size()*4)];
                
                int count=0;
                for(RouteDetail routeDetail:routeDetails){
                       strArray[count]=routeDetail.getComponentName();
                       count=count+1;
                       strArray[count]=routeDetail.getxPoint()+"";
                       count=count+1;
                       strArray[count]=routeDetail.getyPoint()+"";
                       count=count+1;
                       strArray[count]=routeDetail.getComponentText()+"";
                       count=count+1;
                }
                csvPrinter.printRecord(strArray);
                csvPrinter.flush();
         }catch (IOException e) {
             
        }  
    }
   /* 
    public void static CSVRW(FlyCoordinates flyCoordinates){
          try {
                File currentDirFile = new File(".");
                String helper = currentDirFile.getAbsolutePath();
                SAMPLE_CSV_FILE=helper+"live.csv";
                // BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));
                FileWriter pw = new FileWriter(new File(SAMPLE_CSV_FILE),true); 
                CSVPrinter csvPrinter = new CSVPrinter(pw, CSVFormat.DEFAULT);
                double[] strArray = new double[2];
                strArray[0]=flyCoordinates.getLatitude();
                strArray[1]=flyCoordinates.getLongitude();
                csvPrinter.printRecord(strArray);
                csvPrinter.flush();
         }catch (IOException e) {
             
        }  
    } */
     public List<SimuTestSetting> getSimuTestSettingList(String filePath){
         ArrayList<SimuTestSetting> simuTestSettings =new ArrayList<>(); 
          try { 
                    Reader reader = Files.newBufferedReader(Paths.get(filePath));
                    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
                    Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                    int skip=0;
                    for (CSVRecord csvRecord : csvRecords) {
                           if(skip!=0){
                                SimuTestSetting simuTestSetting= new SimuTestSetting();
                                if(!"".equals(csvRecord.get(0))){
                                     simuTestSetting.setSrNo(Integer.valueOf(csvRecord.get(0)));
                                }
                                if(!"".equals(csvRecord.get(1))){
                                    simuTestSetting.setTestSettingName(csvRecord.get(1));
                                }
                                if(!"".equals(csvRecord.get(2))){
                                   simuTestSetting.setGCSAntenna(csvRecord.get(2));
                                }
                                if(!"".equals(csvRecord.get(3))){
                                    simuTestSetting.setADTAntenna(csvRecord.get(3));
                                }
                                if(!"".equals(csvRecord.get(4))){
                                  simuTestSetting.setForwardX(Integer.valueOf(csvRecord.get(4)));
                                }
                                if(!"".equals(csvRecord.get(5))){
                                   simuTestSetting.setMaxDeviationEl(Integer.valueOf(csvRecord.get(5)));
                                }
                                if(!"".equals(csvRecord.get(6))){
                                   simuTestSetting.setMaxDeviationAz(Integer.valueOf(csvRecord.get(6)));
                                 }
                                if(!"".equals(csvRecord.get(7))){
                                  simuTestSetting.setMaxDeviationGa(Integer.valueOf(csvRecord.get(7)));
                                } 
                                if(!"".equals(csvRecord.get(8))){
                                   simuTestSetting.setMaxSensitivity(Integer.valueOf(csvRecord.get(8)));
                                }
                               
                                simuTestSettings.add(simuTestSetting);
                       }
                            skip=skip+1;
                     }
                   csvParser.isClosed();
                   
               
           }catch(IOException | NumberFormatException ex) {
              ex.printStackTrace();
        }finally{
             
       }
          return simuTestSettings;
      }
   public void saveTestSettingDetails(List<SimuTestSetting> simuTestSettings,String filePath){
         
		System.out.println("Prepare file row data. ");
		CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
		FileWriter fWriter = null;
		CSVPrinter csvPrinter = null;
		try
		  {
			            
			fWriter = new FileWriter(filePath);
			/* Create CSVPrinter*/
			csvPrinter = new CSVPrinter(fWriter, csvFormat);
			System.out.println("Print header in file. ");
			/* First create header in csv file. */
   	                csvPrinter.printRecord("Sr. No", "Test Setting Name", "GCS Antenna", "ADT Antenna", "ForwardX", "MaxDeviationEl","MxDeviationAz","MaxDeviationGa","MaxSensitivity");
                	//System.out.println("Loop in the row list and print each row to csv file " + csvFilePath);
			/* Loop the user account list and print to csv file.*/
			for(SimuTestSetting simuTestSetting11 :simuTestSettings){
			    csvPrinter.printRecord(simuTestSetting11.getSrNo(), simuTestSetting11.getTestSettingName(),simuTestSetting11.getGCSAntenna(), simuTestSetting11.getADTAntenna(),simuTestSetting11.getForwardX(), simuTestSetting11.getMaxDeviationEl(),simuTestSetting11.getMaxDeviationAz(),simuTestSetting11.getMaxDeviationGa(),simuTestSetting11.getMaxSensitivity());	
		           
			}
		      System.out.println("Create file compelete successfully. ");
			
		}catch(IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
			try
			{
				if(fWriter!=null)
				{
					fWriter.flush();
					fWriter.close();
				}
				
				if(csvPrinter!=null)
				{
					csvPrinter.close();
				}
			}catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}

    }
   public ArrayList<Line2D> getLiveRouteDettail(){
         ArrayList<Line2D> line2ds =new ArrayList<>(); 
        
         try { 
               File currentDirFile = new File(".");
               String helper = currentDirFile.getAbsolutePath();
               File  file =new   File(helper+"live.csv");
               if(file.isFile()){
                    Reader reader = Files.newBufferedReader(Paths.get(helper+"live.csv"));
                    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
                    Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                    for (CSVRecord csvRecord : csvRecords) {
                         for(int i=0;i<csvRecord.size();i++){
                              System.out.println("com.mobilicom.csv.CSVRW.getLiveRouteDettail()"+Double.valueOf(csvRecord.get(i)));
                              //line2D.setLine(Double.valueOf(csvRecord.get(i)), Double.valueOf(csvRecord.get(i)),Double.valueOf(csvRecord.get(i)),Double.valueOf(csvRecord.get(i)));
                              System.out.println("com.mobilicom.csv.CSVRW.getLiveRouteDettail()"+Double.valueOf(csvRecord.get(i)));
                              line2ds.add(new Line2D.Double(Double.valueOf(csvRecord.get(i)), Double.valueOf(csvRecord.get(i)),Double.valueOf(csvRecord.get(i)),Double.valueOf(csvRecord.get(i))));
                          }
                    }
                    csvParser.isClosed();
                   return line2ds;
               }else{
                return null;
               }
           }catch(IOException | NumberFormatException ex) {
               return null;
        }
      }
    
   
    public RouteDrawing getRouteDettail(String path){
         RouteDrawing routeDrawing =new RouteDrawing();
         List<RouteDetail> routeDetails=new ArrayList<>();  
         ArrayList<Line> lines =new ArrayList<>();
         try { 
               Reader reader = Files.newBufferedReader(Paths.get(path));
               CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
               Iterable<CSVRecord> csvRecords = csvParser.getRecords();
               for (CSVRecord csvRecord : csvRecords) {
                         for(int i=0;i<csvRecord.size();i++){
                         if(csvRecord.get(i).contains("cgshome")){
                            RouteDetail routeDetail=new RouteDetail();
                            routeDetail.setComponentName(csvRecord.get(i));
                            i++;
                            routeDetail.setxPoint(Double.valueOf(csvRecord.get(i)));
                            i++;
                            routeDetail.setyPoint(Double.valueOf(csvRecord.get(i)));
                            i++;
                            routeDetail.setComponentText(csvRecord.get(i));
                            routeDetails.add(routeDetail);
                         }else{
                         if(csvRecord.get(i).contains("wayPoint")){
                            RouteDetail routeDetail=new RouteDetail();
                            routeDetail.setComponentName(csvRecord.get(i));
                            i++;
                            routeDetail.setxPoint(Double.valueOf(csvRecord.get(i)));
                            i++;
                            routeDetail.setyPoint(Double.valueOf(csvRecord.get(i)));
                            routeDetails.add(routeDetail);
                         }
                    }
                   }    
                }
        }catch(Exception  ex) {
            ex.printStackTrace();
        }
        routeDrawing.setRouteDetails(routeDetails);
        routeDrawing.setLines(lines);
       return routeDrawing;
    }
}