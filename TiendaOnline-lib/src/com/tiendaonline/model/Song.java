/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.model;

import com.tiendaonline.libraries.ISong;

/**
 *
 * @author Rayco
 */
public class Song extends Product implements ISong{
    private int position;
    private int minutes;
    private int seconds;
    public Song(String title, String author, float price, int position, 
            int minutes, int seconds) {
        super(title, author, price);
        this.position = position;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getPosition() {
        return position;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
    
    
    
    
}
