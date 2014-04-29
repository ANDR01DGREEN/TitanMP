/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayer.bll;

import java.util.Comparator;

/**
 *
 * @author AJ Green <ajgreenmail@gmail.com>
 * @param <T> accepts type Song
 * Comparator - Tests Song Artists
 */
public class ArtistComparator<T extends Song>
                implements Comparator<T>
{
    @Override
    public int compare(T song1, T song2)
    {
        //Get song artists
        String artist1 = song1.getArtist();
        String artist2 = song2.getArtist();
        
        //Compare artists and return result
        return artist1.compareToIgnoreCase(artist2);
    }
}
