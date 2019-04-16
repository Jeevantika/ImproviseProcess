/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachekafka;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Elcot
 */
public class KafkaReceiver extends Thread{
    KafkaFrame kf; 
    public static String fname;
    
    KafkaReceiver(KafkaFrame f)
    {
        kf=f;
    }
    
    public void run()
    {
        try
        {
            DatagramSocket ds=new DatagramSocket(7000);
            while(true)
            {                
                byte data[]=new byte[500000];
                DatagramPacket dp=new DatagramPacket(data,0,data.length);
                ds.receive(dp);
                String str=new String(dp.getData()).trim(); 
                System.out.println("Received: "+str);
                String req[]=str.split("#");
                if(req[0].equals("DataIngestion"))       
                {
                    fname=req[1].trim();
                    File fe=new File(fname);		
                    FileInputStream fis=new FileInputStream(fe);
                    byte data1[]=new byte[fis.available()];
                    fis.read(data1);
                    fis.close();
                    String dataset=new String(data1);
                    kf.jTextArea1.setText(dataset.trim());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
