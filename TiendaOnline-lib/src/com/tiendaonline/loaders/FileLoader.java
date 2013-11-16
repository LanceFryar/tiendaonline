/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.loaders;

import com.tiendaonline.libraries.ILoader;
import com.tiendaonline.model.Album;
import com.tiendaonline.model.Song;
import com.tiendaonline.model.SongList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Rayco
 */
public class FileLoader implements ILoader {

    @Override
    public Album loadAlbum(String id) {
        File file = new File("/albumes.txt");
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line;
            String[] albumProperties;
            while ((line = bufferedReader.readLine()) != null) {
                albumProperties = line.split(":");
                if (albumProperties[0] == null ? id == null : albumProperties[0].equals(id)) {
                    Album album = new Album(albumProperties[1], albumProperties[2],
                            albumProperties[3], 0);
                    for (Song song : loadSongList(id)) {
                        album.addSong(song);
                    }
                    return album;
                }
            }
            return null;
        } catch (FileNotFoundException exception) {
            //TODO mostrar fallo en bonito
        } catch (IOException exception) {
            //TODO mostrar fallo en bonito
        }
        return null;
    }

    private SongList loadSongList(String id) {
        SongList songList = new SongList();

        File file = new File("/songs"
                + "/" + id + ".txt");
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            String line;
            String[] songProperties;
            while ((line = bufferedReader.readLine()) != null) {
                songProperties = line.split(":");
                songList.add(new Song(songProperties[1], songProperties[2],
                        Float.valueOf(songProperties[3]),
                        Integer.valueOf(songProperties[0]),
                        Integer.valueOf(songProperties[4]),
                        Integer.valueOf(songProperties[5])));

            }
        } catch (FileNotFoundException exception) {
            //TODO mostrar fallo en bonito
        } catch (IOException exception) {
            //TODO mostrar fallo en bonito
        }

        return songList;
    }
}
