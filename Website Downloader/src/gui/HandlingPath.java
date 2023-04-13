/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



/**
 *
 * @author USER
 */
public class HandlingPath {
    
    public String path;
     
     public void setPath(String str) {
         
         this.path = str;
         
     }
     public String handeling(){
         
     this.path = path.replaceAll("\\\\" , "\\\\\\\\");
     
     return path;
     }
     
}
