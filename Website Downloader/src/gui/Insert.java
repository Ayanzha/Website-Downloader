/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ----HP--2017-----
 */
public class Insert {

    File f=new File("E:\\gui\\e\\file.txt");
    int ln;
    String Username,Password,Email;
    
   public void creatFolder()
    {
        if(!f.exists()){
        f.mkdirs();
        }
        
    }
    
    public void readFile()
    {
    try
    {
    FileReader fr=new FileReader(f+"\\logins.txt");
    System.out.println("file exists !");
    }
    catch (FileNotFoundException ex)
    {
    try{
    FileWriter fw=new FileWriter (f+"\\logins.txt");
    System.out.println("File created");
    
    }
    catch(IOException ex1){
    Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex1);
    }
    }
    }
    
    public void addData(String usr,String pswd,String mail)
    {
    try
    {
        RandomAccessFile raf=new RandomAccessFile(f+"\\logins.txt", "rw");
        for(int i=0;i<ln;i++){
        raf.readLine();
        }
        
        raf.writeBytes("Username:"+usr+"\r\n");
        raf.writeBytes("Oassword:"+pswd+"\r\n");
        raf.writeBytes("Email:"+mail+"\r\n");
    }
    catch(FileNotFoundException ex)
    {
     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
    }
    catch(IOException ex)
    {
     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
    }
    
    }
    
    public void checkData(String usr,String pswd)
    {
        try{
    RandomAccessFile raf=new RandomAccessFile(f+"\\logins.txt", "rw");
        String line=raf.readLine();
        Username=line.substring(9);
        Password=raf.readLine().substring(9);
        Email=raf.readLine().substring(6);
        if(usr.equals(Username) & pswd.equals(Password)){
            JOptionPane.showMessageDialog(null, "Password matched");
        }
        else 
        {
          JOptionPane.showMessageDialog(null, "Wrong user/Password");
        }
        
        }
        catch (FileNotFoundException ex){
                Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
                }
        catch (IOException ex)
        {
        Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void logic(String usr,String pswd)
    {
    try{
    RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
    for (int i=0;i<ln;i+=4)
    {System.out.println("count" +i);
    String forUser = raf.readLine().substring(9);
    String forPswd = raf.readLine().substring(9);
        if(usr.equals(forUser) & pswd.equals(forPswd)){
        JOptionPane.showMessageDialog(null, "password matched");
        break;
        }
       
        else if(i==(ln-3))
        {
         JOptionPane.showMessageDialog(null, "password matched");
        break;
        }
        for(int k=1;k<=2;k++)
        {
        raf.readLine();
        }
    }
    }
    catch (FileNotFoundException ex)
    {
     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
    }
     catch (IOException ex)
        {
        Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void countLines ()
    {
    try {
    ln=1;
    RandomAccessFile raf=new RandomAccessFile(f+"\\logins.txt", "rw");
    for (int i=0;raf.readLine()!=null;i++)
    {
    ln++;
    }
    System.out.println("number of lines:"+ln);
    }
    catch (FileNotFoundException ex)
    {
     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
    }
     catch (IOException ex)
        {
        Logger.getLogger(Insert.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
