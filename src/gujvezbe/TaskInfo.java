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
public class TaskInfo {
    
    private String firstTask;
    private String seccondTask;
    private String thirdTask;
    
    TaskInfo(String firstTask, String seccondTask,String thirdTask ){
        
        this.firstTask      =   firstTask;
        this.seccondTask    =   seccondTask;
        this.thirdTask      =   thirdTask;
        
    }

    public String getFirstTask() {
        return firstTask;
    }

    public void setFirstTask(String firstTask) {
        this.firstTask = firstTask;
    }

    public String getSeccondTask() {
        return seccondTask;
    }

    public void setSeccondTask(String seccondTask) {
        this.seccondTask = seccondTask;
    }

    public String getThirdTask() {
        return thirdTask;
    }

    public void setThirdTask(String thirdTask) {
        this.thirdTask = thirdTask;
    }
    
}
