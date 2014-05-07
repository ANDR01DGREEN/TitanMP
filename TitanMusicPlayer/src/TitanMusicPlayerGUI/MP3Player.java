/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayerGUI;

import TitanMusicPlayer.bll.Song;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

/**
 *
 * @author AJ Green <ajgreenmail@gmail.com>
 */
public class MP3Player implements Runnable{
    private Song song = null;
    private volatile boolean playing = false;
    private Player mp3Player;
    
    public MP3Player(Song s){
        song = s;
    }
    
    public synchronized void pause(){
//        try {
//            while(playing){
//                //mp3Player.wait();
//                playing = false;
//                notifyAll();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            
        JOptionPane.showMessageDialog(null, "Pause still hanging - Disabled.");
    }
    
    public synchronized void resumePlay(){
        playing = true;
        notifyAll();
    }
    
    public synchronized void stopPlay(){
        playing = false;
        mp3Player.close();
    }
    
    public synchronized void run(){
        
        try{ //Try to buffer song and load into Player
            FileInputStream fileStream = new FileInputStream(song.getFilePath());
            BufferedInputStream bufferStream = new BufferedInputStream(fileStream);
            mp3Player = new Player(bufferStream);
            playing = true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error loading song:\n" + e);
        }
        
        while(playing){
            try {
                mp3Player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
