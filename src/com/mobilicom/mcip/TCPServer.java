/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobilicom.mcip;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class implements java Socket server
 * @author Dhiraj
 *
 */
public class TCPServer {
    
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 3333;
    
    public static void startTCPServer() throws IOException, ClassNotFoundException{
         //create the socket server object
          server = new ServerSocket(port);
         //keep listens indefinitely until receives 'exit' call or program terminates
         while(true){
            System.out.println("Waiting for client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            //create ObjectOutputStream object
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            String capitalizedSentence="";
           if("GET_GPS_INFO".equals(message))
                 capitalizedSentence =setGETGPSINFO(); 
           if("GET_RSSI_CINR".equals(message))
                 capitalizedSentence ="RSSI_CINR"; 
            if("SET_LINK_DRAW".equals(message))
                 capitalizedSentence ="LINK_DRAW"; 
            if("GET_TRACKING_ANTENNA_INFO".equals(message))
                 capitalizedSentence ="TRACKING_ANTENNA_INFO"; 
            if("GET_SIMULATOR_TRACKING_ANTENNA_CALIBRATION".equals(message))
                 capitalizedSentence ="TRACKING_ANTENNA_CALIBRATION"; 
            if("GET_SIMULATOR_TRACKING_ANTENNA_INIT_PARAM".equals(message))
                 capitalizedSentence ="SIMULATOR_TRACKING_ANTENNA_INIT_PARAM"; 
            if("SET_TRACKING_ANTENNA_DIRECTION".equals(message))
                 capitalizedSentence ="TRACKING_ANTENNA_DIRECTION"; 
            if("SET_TRACKING_ANTENNA_TYPE".equals(message))
                 capitalizedSentence ="TRACKING_ANTENNA_TYPE"; 
            // outToClient.writeBytes(capitalizedSentence);
            //write object to Socket
            oos.writeObject(capitalizedSentence);
            //close resources
            ois.close();
            oos.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
   public static String setGETGPSINFO(){
     
       return null;
   } 
    
}