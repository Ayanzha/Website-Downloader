/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;
import static gui.URL_u.control;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author USER
 */
public class SubPages extends Thread {

    public static controllers control = new controllers();
    public Document Sub_document;
    public String path;
    private String FirstPage;
    public Elements anchor;
    public WebCrawler Web = new WebCrawler();
    public Storage StorSubPage = new Storage();
    private GetJavaScriptFile JavaScript = new GetJavaScriptFile();
    private getCssFile css = new getCssFile();
    private ConnectPages Connect = new ConnectPages();
    private URL_List URL = new URL_List();
    private CreateFolder Folder = new CreateFolder();
    private Images Image = new Images();
    private Audio audio = new Audio();
    private Video video = new Video();

    SubPages(String Path, String FirstPage) {

        this.path = Path;
        this.FirstPage = FirstPage;
    }

    @Override
    public void run() {
       
        Thread.currentThread().setPriority(2);
        System.out.println("hello");
        for (int i = 0; i < 10; i++) {

            System.out.println(i);
        }
        try {
            FullDownload(FirstPage);

        } catch (IOException ex) {
            Logger.getLogger(SubPages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void FullDownload(String FirstPage) throws IOException {

        URL.addURL(FirstPage);
        JavaScript.setFolder(path, "JavaScript");
        css.setFolder(path, "Style");
        Image.setFolder(path, "Images");
        audio.setFolder(path, "Audio");
        video.setFolder(path, "Video");
        String U;

        for (int i = 0; i < URL.size(); i++) {

            U = URL.nextUrl(i);
            Web.set_host(U);
            downloadSubPages(Web.get_html());

        }

    }

    public void downloadSubPages(Document Doc) throws IOException {

        anchor = Doc.select("a");
        String title = Doc.select("title").text();
        String PageFolder;
        String FolderPath = Connect.getValue(title);

        if (FolderPath == null) {
            PageFolder = createPagesFolder(title, path);

        } else {
            PageFolder = createPagesFolder(title, FolderPath.substring(0, FolderPath.lastIndexOf("\\")));
        }

        dowmloadAllAnchor(anchor, PageFolder);
        JavaScript.getDoc(Doc);
        css.getDoc(Doc);
        Image.doc(Doc);
        audio.doc(Doc);
        video.doc(Doc);
        JavaScript.getFromLink();
        css.getFromLink();
        Image.extract_imag();
        audio.extract_imag();
        video.extract_imag();
        if (!Connect.isExist(title)) {
            StorSubPage.write_file(path, Doc);
            Connect.addPage(title, StorSubPage.getPagePath());

        } else {

            String s = Connect.getValue(title);
            s = s.substring(0, s.lastIndexOf("\\"));
            StorSubPage.write_file(s, Doc);
        }

    }

    private void dowmloadAllAnchor(Elements anchor, String PageFolder) {

        for (Element Anchor : anchor) {
            String Href = Anchor.absUrl("href");
            if (!Href.isEmpty()) {
                URL.addURL(Href);
                Web.set_host(Href);
                Sub_document = new Document(null);
                Sub_document = Web.get_html();
                String title = Sub_document.select("title").text();
                if (Connect.isExist(title)) {
                    insertInHomePage(Anchor, Connect.getValue(title));

                } else {
                    StorSubPage.write_file(PageFolder, Sub_document);
                    Connect.addPage(title, StorSubPage.getPagePath());
                    insertInHomePage(Anchor, StorSubPage.getPagePath());
                }
            } else {
                System.out.println("href not found");
            }
        }
    }

    private String createPagesFolder(String PageName, String FolderPage) {

        return Folder.CreateNewFolder(FolderPage, PageName);

    }

    public void insertInHomePage(Element Link, String newpos) {

        Link.attr("href", newpos);
        System.out.println("\n\n\n" + Link.attr("href") + "\n\n\n");

    }
    
}
