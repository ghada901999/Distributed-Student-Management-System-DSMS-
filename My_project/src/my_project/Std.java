/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project;

/**
 *
 * @author user
 */
public class Std {
 public int id;
 public  String name;
 public  int mark;
 public  String  gender;
public  void Mark_update(int x){
    this.mark+=x;
}
    public Std(String line) {
        String []ar=line.split(",");
        this.id = Integer.parseInt(ar[0]);
        this.name = ar[1];
        this.mark = Integer.parseInt(ar[2]);
        this.gender = ar[3];
    }

    @Override
    public String toString() {
        return id + "," + "," + mark +","+ gender + "\n";
    }
    
 
}
