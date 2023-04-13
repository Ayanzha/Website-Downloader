/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;

/**
 *
 * @author USER
 */
public class CreateFolder {

    private File Folder;

    public String CreateNewFolder(String FolderPath, String FolderName) {

        Folder = new File(FolderPath + "\\" + FolderName);
        if (!Folder.exists()) {

            Folder.mkdir();

        } else {

        }
        return FolderPath + "\\" + FolderName;
    }

}
