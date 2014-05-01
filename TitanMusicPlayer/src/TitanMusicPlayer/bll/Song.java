/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayer.bll;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author AJ Green
 */

@Entity
@Table(name = "songs", uniqueConstraints = {
        @UniqueConstraint(columnNames = "songID")})
public class Song implements Serializable {
    @Column(name = "TITLE", unique = false, nullable = false)
    private String title;       //Song Title
    @Column(name = "ARTIST", unique = false, nullable = false)
    private String artist;      //Song Artist
    @Column(name = "FILEPATH", unique = true, nullable = false)
    private String filePath;    //Song file Path
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SONGID", unique = true, nullable = false)
    private int songID;         //Song ID from db

    /* I want to use length, but I don't have time to implement yet
    private String legnth;      //Song Length
     */
    
    //No-arg contructor for hibernate
    private Song() {
        this.artist = "emptyArtist";
        this.title = "emptyTitle";
        this.filePath = "emptyPath";
        this.songID = -1;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }
    
    /*
    Constructor class, takes title and artist and sets for new song
    If length implemented, will need to change
    Empty constructor for no ID3 info?
    */
    public Song(String title, String artist, String path){
        this.title = title;
        this.artist = artist;
        this.filePath = path;
        
        //NEED TO QUERY DB FOR ID!!!!
    }
    
    /*
    Constructor for querying db to fill library
    */
    public Song(String title, String artist, String path, int id){
        this.artist=artist;
        this.filePath=path;
        this.songID=id;
        this.title=title;
    }
    
    /*
    Method to return title of song
    */
    public String getTitle() {
        return this.title;
    }
    
    /*
    Method to return artist of song
    */
    public String getArtist() {
        return this.artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    /*
    Determine if song is equal to passed song
    */
    public boolean equals(Song s){
        boolean isEqual;                    //Holds value of test
        
        /*Nested if to test if Song Title then Artist match
        */
        if (title.equals(s.title)){         //If titles =, test artist
            if(artist.equals(s.artist))     //If artist =, pass true
                isEqual = true;             //Songs are equal
            else 
                isEqual = false;            //Artist mismatch, false
        }
        else
            isEqual = false;                //Title mismatch, false
        
        return isEqual;                     //Return result
    }
    
}
