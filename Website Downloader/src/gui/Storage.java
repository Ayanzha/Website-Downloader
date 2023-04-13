/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;

public class Storage implements user {

    public String path_;
    public WebCrawler web;
    private String PagePath;
    public Storage() {
    }

    public Storage(String p) {
        this.path_ = p;
    }

    @Override
    public void set_path(String path) {
        this.path_ = path;
    }

    @Override
    public String get_path() {
        return this.path_;
    }

    @Override
    public void set_host(String host) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String get_host() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String new_foldwer(String path) {
        File folder = new File(path + "\\" + "folder");
        folder.mkdirs();
        return folder.getPath();//ارجاع مسار المجلد

    }

    public  String new_file(String path_folder, String PageName) {
        
        
        File f = new File(path_folder + "\\" + PageName + ".html");
        
        
        try {
            
            f.createNewFile();
            
        } catch (IOException ex) {
            
            System.out.print("pro");
            
        }
        
        return path_folder + "\\" + PageName + ".html";

    }

    public void write_file(String FolderPath,Document document) {
        String PageName = document.select("title").text();
        PagePath = FolderPath + "\\" + PageName + ".html";
        new_file(FolderPath,PageName);
        try {
            
            FileWriter w = new FileWriter(PagePath);
            
            w.write(document.html());
            
            w.close();
           
        } catch (IOException ex) {
            
            System.out.print("there is error");

        }
       
    }
    public String getPagePath (){
    
    return this.PagePath;
    
    }
}
