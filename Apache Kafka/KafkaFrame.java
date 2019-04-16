/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apachekafka;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;
import java.util.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

/**
 *
 * @author Elcot
 */
public class KafkaFrame extends javax.swing.JFrame {

    /**
     * Creates new form KafkaFrame
     */
    
    long executionTime;
    
    public KafkaFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));

        jLabel1.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apache Kafka");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Data Processing using Apache Kafka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Forward to Improvising Processing Framework");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String processedResults=jTextArea1.getText().trim();
        
        String msg="KafkaProcessedResults#"+processedResults+"#"+executionTime;
        JOptionPane.showMessageDialog(this,"Processed Results Forwarded Successfully!");
        packetTransmission(msg,5000);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        long startTime=System.currentTimeMillis();
        wordCount(KafkaReceiver.fname.trim());
        long endTime=System.currentTimeMillis();
        executionTime=endTime-startTime;
        System.out.println("executionTime: "+executionTime);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KafkaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KafkaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KafkaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KafkaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KafkaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void wordCount(String fileName) 
    {        
        try
        {
            // Configure Spark to connect to Kafka running on local machine
            Map<String, Object> kafkaParams = new HashMap<>();
            kafkaParams.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
            kafkaParams.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
                            "org.apache.kafka.common.serialization.StringDeserializer");
            kafkaParams.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
                            "org.apache.kafka.common.serialization.StringDeserializer");
            kafkaParams.put(ConsumerConfig.GROUP_ID_CONFIG,"group1");
            kafkaParams.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
            kafkaParams.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);

            //Configure Spark to listen messages in topic test
            Collection<String> topics = Arrays.asList("test");

            SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("SparkKafka10WordCount");

            //Read messages in batch of 30 seconds
            JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(30));

            // Start reading messages from Kafka and get DStream
            final JavaInputDStream<ConsumerRecord<String, String>> stream =
                    KafkaUtils.createDirectStream(jssc, LocationStrategies.PreferConsistent(), 
                                                  ConsumerStrategies.<String,String>Subscribe(topics,kafkaParams));

            // Read value of each message from Kafka and return it
            JavaDStream<String> lines = stream.map(new Function<ConsumerRecord<String,String>, String>() {
                @Override
                public String call(ConsumerRecord<String, String> kafkaRecord) throws Exception {
                    return kafkaRecord.value();
                }
            });

            // Break every message into words and return list of words
            JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
                @Override
                public Iterator<String> call(String line) throws Exception {
                    return Arrays.asList(line.split(" ")).iterator();
                }
            });

            // Take every word and return Tuple with (word,1)
            JavaPairDStream<String,Integer> wordMap = words.mapToPair(new PairFunction<String, String, Integer>() {
                @Override
                public Tuple2<String, Integer> call(String word) throws Exception {
                    return new Tuple2<>(word,1);
                }
            });

            // Count occurance of each word
            JavaPairDStream<String,Integer> wordCount = wordMap.reduceByKey(new Function2<Integer, Integer, Integer>() {
                 @Override
                 public Integer call(Integer first, Integer second) throws Exception {
                     return first+second;
                 }
             });

            //Print the word count
            //wordCount.print();

            //jssc.start();
            //jssc.awaitTermination();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            String foldername="CountData";        
            File directory = new File(foldername);        
            if(directory.exists())
            { 
                try
                {        	   
                    delete(directory);        	
                }
                catch(Exception e)
                {
                    e.printStackTrace();               
                }            
            }
            
            String inputFilename=kafkaInput(fileName.trim());
            
            System.setProperty("hadoop.home.dir", "C:\\winutils");
            String as[]={inputFilename.trim(),"CountData"};	
            Configuration conf = new Configuration();
            String[] otherArgs = new GenericOptionsParser(conf, as).getRemainingArgs();	
            Job job = new Job(conf, "word count");
            job.setJarByClass(WordCount.class);
            job.setMapperClass(WordCount.TokenizerMapper.class);
            job.setCombinerClass(WordCount.IntSumReducer.class);
            job.setReducerClass(WordCount.IntSumReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
            FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
            int val=job.waitForCompletion(true) ? 0 : 1;
            Thread.sleep(1000);            
            String fname2="CountData/part-r-00000";
            File fe2=new File(fname2);		
            FileInputStream fis1=new FileInputStream(fe2);
            byte data1[]=new byte[fis1.available()];
            fis1.read(data1);
            fis1.close();
            String processedResults=new String(data1);
            JOptionPane.showMessageDialog(this, "Data Processed Successfully!");
            jTextArea1.setText(processedResults.trim());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void packetTransmission(String msg, int pt) {
        try
        {
            byte data1[]=msg.getBytes();
            DatagramSocket ds1=new DatagramSocket();
            DatagramPacket dp1=new DatagramPacket(data1,0,data1.length,InetAddress.getByName("127.0.0.1"),pt);
            ds1.send(dp1);
            System.out.println("Port is "+pt+"\n");                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }

    public void delete(File file) throws IOException
    { 
        if(file.isDirectory())
        {                 
            if(file.list().length==0)
            {    			
    		file.delete();    		
            }
            else
            {    			    		   
        	String files[] = file.list();     
        	for (String temp : files) 
                {                        
        	    File fileDelete = new File(file, temp);        		                         
        	    delete(fileDelete);
        	}        		                        
        	if(file.list().length==0)
                {
                    file.delete();        	    
        	}
            }    		
        }
        else
        {    		
            file.delete();           
    	}
    }

    private String kafkaInput(String fileName) {
        String content=jTextArea1.getText().trim().replaceAll(",", "\n");
        String sp[]=fileName.trim().split("\\.");
        
        String inputFileName=sp[0].trim()+"1"+sp[1].trim();
        try
        {
            File fe=new File(inputFileName);
            String sg=content.trim();
            FileOutputStream fos=new FileOutputStream(fe);
            fos.write(sg.getBytes());
            fos.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return inputFileName.trim();
    }

    public static class WordCount 
    {
        public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>
        {    
            private final static IntWritable one = new IntWritable(1);
            private Text word = new Text();
      
            public void map(Object key, Text value, Context context) throws IOException, InterruptedException 
            {
                StringTokenizer itr = new StringTokenizer(value.toString());
                while (itr.hasMoreTokens()) 
                {
                    word.set(itr.nextToken());
                    context.write(word, one);
                }
            }
        }  
        public static class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable> 
        {
            private IntWritable result = new IntWritable();

            public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException 
            {
                int sum = 0;
                for (IntWritable val : values) 
                {
                    sum += val.get();
                }
                result.set(sum);
                context.write(key, result);
            }
        } 
    }
}
