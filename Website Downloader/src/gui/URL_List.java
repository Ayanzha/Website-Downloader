/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.nodes.Document;

/**
 *
 * @author USER
 */
public class URL_List {

    private ArrayList<String> List = new ArrayList();

    public void addURL(String Url) {
        if(!List.contains(Url)){
        
        List.add(Url);
        }
        
    }
    public String nextUrl(int i){
        
        return List.get(i);
    
    }
    public int size(){
    
        return List.size();
    
    }
}
