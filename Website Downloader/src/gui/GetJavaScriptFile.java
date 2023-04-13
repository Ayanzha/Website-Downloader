/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import javax.swing.JRootPane;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author USER
 */
public class GetJavaScriptFile extends DownloadStyleAndJs {

    @Override
    public void getFromLink() throws IOException {

        Elements Scripts = document.getElementsByTag("script");

        for (Element script : Scripts) {

            String src;
            if (script.hasAttr("src")) {

                src = script.absUrl("src");

                FileName = getFileName(src);
                if (FileExist()) {

                    insertInHtml(script);

                } else {

                    insertInHtml(script);
                    read(src);

                }

            } else {
            }

        }

    }

    /**
     *
     * @param Link
     */
    @Override
    public void insertInHtml(Element Link) {
        Link.attr("src", FolderName + "\\" + FileName);

    }

}
