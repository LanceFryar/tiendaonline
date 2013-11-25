/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.beans;

import com.tiendaonline.interfacebeans.ICatalog;
import com.tiendaonline.libraries.IAlbum;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.loaders.FileLoader;
import com.tiendaonline.libraries.ILoader;
import com.tiendaonline.model.Album;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Rayco
 */

@Stateless(mappedName = "Catalog")
public class Catalog implements ICatalog{
    private final ArrayList<IAlbum> catalog;

    public Catalog(){
        catalog = new ArrayList();
        setCatalog();
    }
    

    final void setCatalog () {
        ILoader fileLoader = new FileLoader();
        int i = 1;
        Album album = fileLoader.loadAlbum(""+i);
        while (album != null) {
            catalog.add(album);
            i++;
            album = fileLoader.loadAlbum(""+i);
        }
    }

    @Override
    public IProduct getProduct(String id) {
        try{
        IProduct product = catalog.get(Integer.valueOf(id)-1);
        return product;
        }catch (IndexOutOfBoundsException e){
            return null;
        }
    }
    
  
    
    
    
}
