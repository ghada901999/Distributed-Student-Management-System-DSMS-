/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class File_Helper {
 public String file_name;

    public File_Helper(String file_name) {
        this.file_name = file_name;
    }
 public void  Data_save(String data) throws IOException{
     FileWriter writer = new FileWriter(file_name, false);
writer.write(data);
writer.close();
 }
 public String  Get_Data_by_id(int id) throws IOException{
    String str="";
    try  
{  
File file=new File(file_name);    
FileReader fr=new FileReader(file);     
BufferedReader br=new BufferedReader(fr);  
 
String line;  
while((line=br.readLine())!=null)  
{  
    Std s=new Std(line);
    if(s.id==id){
        str+=s.toString();
    }
}  
fr.close();   
    }  
catch(IOException e)  
{  
  System.out.println(e.getMessage());
}  
    return  str;
 }
 public String  edite_Data(int x) throws IOException{
    String str="";
    try  
{  
File file=new File(file_name);    
FileReader fr=new FileReader(file);     
BufferedReader br=new BufferedReader(fr);  
 
String line;  
while((line=br.readLine())!=null)  
{  
    Std s=new Std(line);
    s.Mark_update(x);
    str+=s.toString();
}  
fr.close();   
    }  
catch(IOException e)  
{  
    System.out.println(e.getMessage());
}  
    return  str;
 }
}
