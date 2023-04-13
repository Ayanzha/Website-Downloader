/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author ----HP--2017-----
 */
//class Sound
public class play {
       public void Play()
    {
        try{      
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("C:\\Windows\\Media\\Windows Startup.wav"));      
        AudioFormat format = stream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
        Clip clip = (Clip) AudioSystem.getLine(info);        
         clip.open(stream);      
         clip.start();    
    } catch (Exception e)
    {      
         e.printStackTrace();    
    }  
    }
}
