/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.model;

import com.tiendaonline.libraries.IAlbum;
import java.io.Serializable;

/**
 *
 * @author Rayco
 */

public class Album extends Product implements IAlbum, Serializable{
    private String cover;
    private SongList songList;

    public Album(String cover, String title, String author, float price, String id) {
        super(title, author, price, id);
        this.cover = cover;
        songList = new SongList();
    }

    @Override
    public String getCover() {
        return cover;
    }

    @Override
    public Song getSong(int track) {
        try{
            return songList.get(track-1);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            return null;
        }
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    
    public void addSong (Song song) {
        songList.add(song);
        price += song.getPrice();
    }
    
    public void addSong (Song song, int position) {
        songList.add(position, song);
    }
}
