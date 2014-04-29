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
 * Comparator - Tests Song Titles
 */
public class TitleComparator<T extends Song>
                implements Comparator<T> 
{
    @Override
    public int compare(T song1, T song2)
    {
        //Get song titles
        String title1 = song1.getTitle();   
        String title2 = song2.getTitle();
        
        //Compare titles and return result
        return title1.compareToIgnoreCase(title2);
    }
}
