/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachekafka;

/**
 *
 * @author Elcot
 */
public class Main {
    public static void main(String[] args) 
    {                
        try
        {                    
            //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");

            KafkaFrame kf=new KafkaFrame();
            kf.setTitle("Kafka Frame");
            kf.setVisible(true);
            kf.setResizable(false);
            
            KafkaReceiver kr=new KafkaReceiver(kf);
            kr.start();
        }
        catch (Exception ex)
        {
            
        }        
    }
}
