/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvisingprocessingframework;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Elcot
 */
public class MainFrameReceiver extends Thread{
    MainFrame mf;
    public static long sparkexecutionTime,kafkaexecutionTime;
    
    MainFrameReceiver(MainFrame f)
    {
        mf=f;
    }
    
    public void run()
    {
        try
        {
            DatagramSocket ds=new DatagramSocket(5000);
            while(true)
            {                
                byte data[]=new byte[500000];
                DatagramPacket dp=new DatagramPacket(data,0,data.length);
                ds.receive(dp);
                String str=new String(dp.getData()).trim(); 
                System.out.println("Received: "+str);
                String req[]=str.split("#");
                if(req[0].equals("SparkProcessedResults"))       
                {
                    String processedResults=req[1].trim();
                    sparkexecutionTime=Long.parseLong(req[2].trim());
                    mf.jTextArea2.setText(processedResults.trim());
                }
                if(req[0].equals("KafkaProcessedResults"))       
                {
                    String processedResults=req[1].trim();
                    kafkaexecutionTime=Long.parseLong(req[2].trim());
                    mf.jTextArea3.setText(processedResults.trim());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
