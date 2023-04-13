/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author USER
 */
public class DownloadStyleAndJs {

    public URL url;
    public Document document = new Document(null);
    public BufferedReader readFile = null;
    public StringBuilder writeStringFile = null;
    public String FileName = null;
    protected CreateFolder Folder;
    protected String FolderName;

    public void getDoc(Document Doc) {

        this.document = Doc;
    }

    public void setFolder(String FolderPath, String FolderName) {

        Folder = new CreateFolder();
        this.FolderName = Folder.CreateNewFolder(FolderPath, FolderName);
       
    }

    public String getFileName(String Href) {

        String FileName = Href.substring(Href.lastIndexOf("/") + 1, Href.length());
        return FileName;

    }

    public void getFromLink() throws IOException {}

    public void insertInHtml(Element Link) {}

    public void read(String src) throws IOException {

        url = new URL(src);

        System.out.println("this is URL :" + "\n" + url);
        try {

            readFile = new BufferedReader(new InputStreamReader(url.openStream()));
            System.err.println(readFile);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        String line;

        writeStringFile = new StringBuilder();

        while ((line = readFile.readLine()) != null) {

            writeStringFile.append(line);
            writeStringFile.append(System.lineSeparator());
        }

        writeInFile(writeStringFile.toString());

    }

    public void writeInFile(String content) {

        File file = new File(FolderName + "\\" + FileName);
        FileWriter writer = null;

        try {
            file.createNewFile();
            writer = new FileWriter(FolderName + "\\" + FileName);

            writer.write(content);

            writer.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
    public boolean FileExist() {
        File file = new File(FolderName + "\\" + FileName);
        return file.exists();
    
    }

}
