/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayer.bll;

//Import packages
import TitanMusicPlayer.da.HibernateUtil;
import TitanMusicPlayer.da.SongRepository;
import java.util.ArrayList; //Accesses ArrayList 
import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author AJ Green
 */
public class Library {
    //Private Array List for Library Songs
    private ArrayList<Song> songList;
    
    //Create repositories
    SongRepository songRepo = new SongRepository();
    
    /*
    Constructor for Library Object
    */
    public Library(){
        this.songList = new ArrayList<Song>(songRepo.getSongsList());
    }
    
    /*
    Add song to Library songList
    */
    public void addToLibrary(Song s){
        //Add to internal list
        this.songList.add(s);
        //Add to DB
        //songRepo.addSong(s);
    }
    
    /*
    Remove song from library by index
    */
    public void removeFromLibrary(int i)
    {
        Song s = songList.get(i);
        //Remove from internal
        this.songList.remove(i);
        //Remove from DB
        //songRepo.removeSong(s);
    }
    
    /*
    Remove song from Library songList 
    */
    public void removeFromLibrary(Song s){
        this.songList.remove(s);
        //songRepo.removeSong(s);
    }
    
    /*
    Return Library for display
    */
    
    public ArrayList<Song> getLibrary()
    {
        return songList;
    }
    
    /*
    Sort command for sorting Library by song title
    */
    public void sortByTitle()
    {
        Collections.sort(songList, new TitleComparator<Song>());
    }
    
    /*
    Sort command for sorting library by aong artist
    */
    public void sortByArtist()
    {
        Collections.sort(songList, new ArtistComparator<Song>());
    }
    
    /*
    Method returns 1D array of titles
    */
    public ArrayList<String> getAllTitles()
    {
        ArrayList<String> songTitles = new ArrayList<>();
        
        //Run through each song and get title, set in array
        for (Song s : songList)
        {
            songTitles.add(s.getTitle());
        }
        
        //Return array of titles
        return songTitles;
    }
    
    /*
    Method returns 1d array of artists
    */
    public ArrayList<String> getAllArtists()
    {
        ArrayList<String> songArtists = new ArrayList<>();
        
        //Run through each song and get artist, set in array
        for (Song s : songList)
        {
            songArtists.add(s.getArtist());
        }
        
        //Return array of artists
        return songArtists;
    }
    
    public boolean isEmpty() {
        return songList.isEmpty();
    }
    
    public Song getSongByIndex(int i)
    {
        return songList.get(i);
    }
}
