/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author USER
 */
public class getCssFile extends DownloadStyleAndJs{
    
    
    @Override
    public void getFromLink() throws IOException {
        
        Elements LinkCss = document.select("link[rel$=stylesheet]");
        for (Element Link : LinkCss) {
            
            String href;
            
            href = Link.absUrl("href");
            
            FileName = getFileName(href);
            
             if (FileExist()) {

                    insertInHtml(Link);

                } else {

                    insertInHtml(Link);
                    read(href);
             }

            
            
        }
        
    }

    /**
     *
     * @param Link
     */
    @Override
    public void insertInHtml(Element Link){
        
        Link.attr("href", FolderName + "\\" + FileName);
        
    }
    
       
}
    

