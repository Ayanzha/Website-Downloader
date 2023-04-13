/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author USER
 */
public class ConnectPages {

    private final Map<String, String> Pages = new HashMap<>();

    public void addPage(String PageName, String PageDir) {
        if(!Pages.containsKey(PageName)){
            
             Pages.put(PageName, PageDir);
        } else{}
       

    }

    public void print() {

        System.out.println(Pages);

    }

    public String getValue(String Key) {

        if (Pages.containsKey(Key)) {

            return Pages.get(Key);

        } else {

            return null;

        }

    }
    
    public Boolean isExist(String Key) {
    
        return Pages.containsKey(Key);
        
    }

}
