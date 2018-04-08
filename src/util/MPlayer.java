/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;

/**
 *
 * @author PreBoosted
 */
public class MPlayer {
   
    public  void clickSound() throws IOException{
        
            InputStream inputStream = getClass().getResourceAsStream("/click1amp.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
    }
   
    public  void exitSound() throws IOException{
        
            InputStream inputStream = getClass().getResourceAsStream("/exit1.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
    }
   public  void typing1Sound() throws IOException{
        
            InputStream inputStream = getClass().getResourceAsStream("/typed1.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
    }
   public  void typing2Sound() throws IOException{
        
            InputStream inputStream = getClass().getResourceAsStream("/typed2.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
    }
   public  void typing3Sound() throws IOException{
        
            InputStream inputStream = getClass().getResourceAsStream("/typed3.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
    }
   public  void typing4Sound() throws IOException{
        
            InputStream inputStream = getClass().getResourceAsStream("/typed4.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
    }
}

