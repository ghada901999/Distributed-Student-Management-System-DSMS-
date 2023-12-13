/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author user
 */
public class S1 {
    public  static  File_Helper file=new File_Helper("D1.txt");
    public static void main(String[] args) {
       
        Change_Mark g1=new Change_Mark();
        g1.f=file;
        g1.time=TimeUnit.SECONDS.toMillis(10);
        g1.num=1;
         Change_Mark g2=new Change_Mark();
        g2.f=file;
        g2.time=TimeUnit.SECONDS.toMillis(12);
        g2.num=-1;
        
       g1.start();
         g2.start();
          int port=4050;
           
         
        
        
        try(ServerSocket ss = new ServerSocket(port)){
     
            while(true){
               
                
                new Th_class(ss.accept()).start();
               

            }
            
             
        }
        catch(IOException e) {
            System.out.println("Server Exception : " + e.getMessage());
        }

    
    }
static class Th_class extends Thread {
    private Socket socket;
private int n;
    public Th_class(Socket socket){
        this.socket = socket;
       
       
    }

    @Override
    public void run() {
       
      
        try{
            
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            String read=din.readUTF();
            System.out.println(read);
            if(read.split("&")[0].equals("s")){
                S1.file.Data_save(read.split("&")[1]);
                dout.writeUTF("Saved");
            }
            else {
                String []sp=read.split(",");
                int op=Integer.parseInt(sp[0]);
                 int id=Integer.parseInt(sp[1]);
                 if(op==1){
                     String re=S1.file.Get_Data_by_id(id);
                     Std s=new Std(re);                    
                     dout.writeUTF(s.mark+"");
                 }
                 if(op==2){
                     String re=S1.file.Get_Data_by_id(id);
                     Std s=new Std(re);                    
                     dout.writeUTF(s.gender+"");
                 }
                  if(op==3){
                     String re=S1.file.Get_Data_by_id(id);
                     Std s=new Std(re);                    
                     dout.writeUTF(s.mark+","+s.gender);
                 }
               
            
            }
        }
        catch(IOException e){
            System.out.println("Oops : " + e.getMessage());
        }
        finally {
            
            try{
                socket.close();
                socket.close();
            }
            catch(IOException e){

            }
        }
    
}
}}



