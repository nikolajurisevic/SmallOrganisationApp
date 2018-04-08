/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gujvezbe;

/**
 *
 * @author PreBoosted
 */
public class TaskAt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        LoadingForm lf = new LoadingForm();
       
        MainForm nm = new MainForm();
        
      
        
        
        //NewJFrame fw = new NewJFrame();
         
        
        
       
        nm.setLocationRelativeTo(null);
        
           lf.setVisible(true);
        lf.setLocationRelativeTo(null);
        for(int i = 0 ; i < 101; i++){
        
        lf.jLabel4.setText(i+"%");
        Thread.sleep(15);
        
        }
        
        Thread.sleep(1000);
        lf.dispose();
       
        nm.setVisible(true);
          
       // fw.setVisible(true);
    
    }
    
}
