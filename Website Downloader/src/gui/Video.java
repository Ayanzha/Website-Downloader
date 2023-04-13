/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedOutputStream;//
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ----HP--2017-----
 */
public class Video {

    public URL url;
    public ArrayList imges = new ArrayList();//source قبل التعديل
    public ArrayList set_img = new ArrayList();//sourبعدل التعديل 
    public Document document = new Document(null);
    private String FolderName;
    private CreateFolder Folder;

    public void doc(Document document) {
        this.document = document;
    }
    public void setFolder(String FolderPath, String FolderName) {

        Folder = new CreateFolder();
        this.FolderName = Folder.CreateNewFolder(FolderPath, FolderName);
       
    }
    public void extract_imag()//استخراج الصور 
    {
        try {

            Elements img = document.getElementsByTag("video");
            //  System.out.println(web.get_html());
            System.err.println(Folder);
            for (Element el : img) {//امشي عالمصفوفة
                String src = el.absUrl("src");//جبلي المسار
                imges.add(src);// حط المسار بالاري ليست
                System.out.println(src);
                getImages(src);//استدعاء لتابع عم يحملي الصورة
                setter_imag(src, FolderName, el);//لتعديل source
                
            }
        } catch (IOException ex) {
            
            System.out.println("error here 1");
            
      }

    }

    public void getImages(String src) throws IOException {

        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(0, indexname);//جزئلي المسار
        }
        
        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname + 1 , src.length());
        URL url = new URL(src);
        InputStream in = url.openStream();
        OutputStream out = new BufferedOutputStream(new FileOutputStream(FolderName + "\\" +name));
        set_img.add(FolderName + name);
        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();

    }

    public void setter_imag(String src, String path, Element img) {
        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(0, indexname - 1);
        }

        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname + 1, src.length());

        img.outerHtml();
        img.attr("src", path + "\\" + name);
        System.out.println(img.attr("src"));
        img.outerHtml();

    }

   

}
