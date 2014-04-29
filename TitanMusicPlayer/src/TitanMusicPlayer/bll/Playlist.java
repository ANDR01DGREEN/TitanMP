/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayer.bll;
//Import packages
import java.text.DateFormat;
import java.util.ArrayList;                     //Array List functionality
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author AJ
 */
public class Playlist {
    
    private String PLName;               //Name of playlist
    private ArrayList<Song> playlist;    //Stores current playlist
    private int currentSong = -1;        //Stores index of playing song
    
    /**
     * Constructor takes new playlist name and creates empty list
     * @param name accepts String Name
    */
    public Playlist(String name)
    {
        this.PLName = name;                 //Set passed name as new name
        this.playlist = new ArrayList<>();  //Create a new list
    }
    
    /*
    Overloaded constructor for no name playlist, useful onLoad
    */
    public Playlist()
    {
        //Set generic name with Date + Time
        this.PLName = "PL " + DateFormat.getDateInstance().format(new Date());
        //Create new list
        this.playlist = new ArrayList<>();          
    }
    
    /*
     *Song Skip
    Accepts Index of song in playlist to skip
    May be overidden at later date with Song compare also
    */
    public void songSkip()
    {
        //Test if current song is available
        if (currentSong > -1)
        {
            currentSong++;
        }
    }
    
    /*
    Returns playlist for display
    */
    public ArrayList<Song> getPlaylist()
    {
        return playlist;
    }
    
    public boolean isEmpty(){
        return playlist.isEmpty();
    }

    public String getPLName() {
        return PLName;
    }

    public int getCurrentSong() {
        return currentSong;
    }

    public void setPLName(String PLName) {
        this.PLName = PLName;
    }

    public void setCurrentSong(int currentSong) {
        this.currentSong = currentSong;
    }
    
    public void addSongToPlaylist(Song s){
        this.playlist.add(s);
    }
    
    //Remove song by index
    public void removeSongFromPlaylist(int i){
        this.playlist.remove(i);
    }
    
    //Remove song itself
    public void removeSongFromPlaylist(Song s){
        this.playlist.remove(s);
    }
}
