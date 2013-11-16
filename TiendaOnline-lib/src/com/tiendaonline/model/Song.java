/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.model;

import com.tiendaonline.libraries.ISong;
import java.io.Serializable;

/**
 *
 * @author Rayco
 */

public class Song extends Product implements ISong, Serializable{
    private int position;
    private int minutes;
    private int seconds;
    public Song(String title, String author, float price, int position, 
            int minutes, int seconds, String id) {
        super(title, author, price, id);
        this.position = position;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }
    
    
    
    
}
