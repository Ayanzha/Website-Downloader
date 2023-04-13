
package gui;


import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebCrawler implements user {

    public String host_;  
    public Document doc;
    
    public WebCrawler()
    {
    }
    public WebCrawler(String host)
    {  this.host_=host;
    }
    @Override
    public void set_host(String host) {
        this.host_=host;
    }

    @Override
    public void set_path(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String get_host() {
    
    return host_;
    }
    
    @Override
    public String get_path() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
     public  Document  get_html()
           {
           try {
             doc=Jsoup.connect(get_host()).get();//فتح اتصال 
             
           } catch (IOException ex) {
            System.out.print("No EnterNet");
          
           }
           
                return doc;
           }
           
   }
    

