/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class STd_CL {
    public static void main(String[] args) {
        int id;
        Scanner input=new Scanner(System.in);
        System.out.println("input id 1-5");
        id=input.nextInt();
            try(Socket socket = new Socket("localhost",4000)){
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                while (true) {            
                    System.out.println("1- Grade alone ");
                System.out.println("2- Gender alone  ");
                System.out.println("3- Grade and gender together ");
                
                System.out.println("4-Exit ");
                int op=input.nextInt();
                
                    dout.writeUTF(op+","+id);
                    if(op==4){
                        break;
                    }
                    System.out.println( "From Manger + "+din.readUTF());
                }
       
          
           

        } catch(IOException e){
            System.out.println("Client Error : "+ e.getMessage());
       
        }
    }
}
