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

/**
 *
 * @author user
 */
public class Manger {
   
      public static  void Saved_connect(){
          Connect1();
          Connect2();
          Connect3();
          
      }
      public static  String get_conncet(String line){
          String str="";
          try(Socket socket = new Socket("localhost",4050)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
          
       dout.writeUTF(line);
       str+=din.readUTF()+",";
          
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }
          try(Socket socket = new Socket("localhost",5000)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(line);
       str+=din.readUTF()+",";
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }
          try(Socket socket = new Socket("localhost",5555)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            dout.writeUTF(line);
       str+=din.readUTF();
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }
          System.out.println(str);
          return str;
          
      }
   public static void Connect1(){
       try(Socket socket = new Socket("localhost",4050)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
          
       dout.writeUTF("s&"+"1,Mhmd,80,M\n" +
"2,Amenah,90,F\n" +
"3,Ahmad,70, M\n" +
"4,Saleem,90,M\n" +
"5,Fatimah,95,F");
           System.out.println(din.readUTF());
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }

   }
   public static void Connect2(){
       try(Socket socket = new Socket("localhost",5000)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
          
       dout.writeUTF("s&"+"1,Mhmd,80,M\n" +
"2,Amenah,90,F\n" +
"3,Ahmad,70, M\n" +
"4,Saleem,95,M\n" +
"5,Fatimah,95,F");
           System.out.println(din.readUTF());
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }

   }
   public static void Connect3(){
       try(Socket socket = new Socket("localhost",5555)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
          
       dout.writeUTF("s&"+"1,Mhmd,80,M\n" +
"2,Amenah,90,F\n" +
"3,Ahmad,70, M\n" +
"4,Saleem,85,M\n" +
"5,Fatimah,95,F");
           System.out.println(din.readUTF());
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }

   }
    public static void main(String[] args) {
       
        Saved_connect();
        
       
          int port=4000;
           
         
        
        
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
            while (true) {                
                 String read=din.readUTF();
                 System.out.println(read);
                 String []sp=read.split(",");
                 int op=Integer.parseInt(sp[0]);
                 
                 if(op==1){
                    String str=Manger.get_conncet(read);
                     System.out.println(str);
                      String []sp2=str.split(",");
                      int mark1=Integer.parseInt(sp2[0]);
                      int mark2=Integer.parseInt(sp2[1]);
                      int mark3=Integer.parseInt(sp2[2]);
                      if(mark1==mark2 || mark1==mark3 ){
                           dout.writeUTF("mark is "+mark1);
                      }
                      else if(mark2==mark1 || mark2==mark3 ){
                           dout.writeUTF("mark is "+mark2);
                      }
                      else {
                          dout.writeUTF("sorry grade not available now. Try late");
                      }
                    
                     
                 }
                 if(op==2){
                    String str=Manger.get_conncet(read);
                    System.out.println(str);
                     dout.writeUTF(str);
                 }
                 if(op==3){
                    String str=Manger.get_conncet(read);
                    System.out.println(str);
                     dout.writeUTF(str);
                 }
                 if(op==4){
                     break;
                 }
            }
             this.socket.close();
           
            
            
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





