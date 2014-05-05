/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TitanMusicPlayer.bll;

import org.jboss.logging.Param;

/**
 *
 * @author AJ Green <ajgreenmail@gmail.com>
 */
public class Account {
    private String username;
    private String password;
    private String email;
    
    //User settings can be added at a later date
    
    //Constructor for Account class
    //@param u as username, e as email, p as password, all String type
    public Account(String u, String e, String p){
        username = u;
        email = e;
        password = p;
    }
    
    //Constructor for Account when blank
    public Account(){
        username = "defUser";
        email = "defEmail";
        password = "defPassword";
    }
    
    @Override
    //Override toString for debug
    public String toString(){
        return "\nUsername : " + username + "\nEmail : " + email +
                "\nPassword : " + password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
