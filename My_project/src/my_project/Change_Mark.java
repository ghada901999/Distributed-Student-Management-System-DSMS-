/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Change_Mark  extends  Thread{
    public  int num;
    public  long time;
    public  File_Helper f;
    
    @Override
    public void run() {
         while (true) {    
        try {
                       
                
            
            Thread.sleep(time);
         String D=   f.edite_Data(num);
        f.Data_save(D);
        } catch (InterruptedException ex) {
            Logger.getLogger(Change_Mark.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Change_Mark.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
  }
}
