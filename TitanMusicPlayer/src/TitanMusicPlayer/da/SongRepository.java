/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayer.da;

import TitanMusicPlayer.bll.Song;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author AJ Green <ajgreenmail@gmail.com>
 */
public class SongRepository {
    Session session = null;
    
    public SongRepository(){
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List getSongsList(){
        List<Song> songs = null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            songs = session.createCriteria(Song.class).list();
        } catch (Exception e){
            e.printStackTrace();
        }
        return songs;
    }
    
    public void addSong(Song s){
        org.hibernate.Transaction tx = session.beginTransaction();
        session.saveOrUpdate(s);
        tx.commit();
    }
    
    public void removeSong(Song s){
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            session.delete(s);
            tx.commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public Song getById(int id){
        Song song = null;
        
        org.hibernate.Transaction tx = session.beginTransaction();
        song = (Song) session.get(Song.class, id);
        
        return song;
    }
}
