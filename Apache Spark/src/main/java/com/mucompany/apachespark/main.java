 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachespark;

import javax.swing.UIManager;

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

            SparkFrame sf=new SparkFrame();
            sf.setTitle("Spark Frame");
            sf.setVisible(true);
            sf.setResizable(false);
            
            SparkReceiver sr=new SparkReceiver(sf);
            sr.start();
        }
        catch (Exception ex)
        {
            
        }        
    }
}

