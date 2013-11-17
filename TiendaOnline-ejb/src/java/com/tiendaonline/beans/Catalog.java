/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.beans;

import com.tiendaonline.libraries.IAlbum;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.loaders.FileLoader;
import com.tiendaonline.libraries.ILoader;
import java.util.ArrayList;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Rayco
 */

@Remote(ICatalog.class)
@Stateless
public class Catalog implements ICatalog{
    private ArrayList<IAlbum> catalog;

    @Override
    public IProduct getProduct(String id) {
        if (catalog == null) {
            ILoader fileLoader = new FileLoader();
            int i = 1;
            while (catalog.add(fileLoader.loadAlbum(""+i))) {
                i++;
            } 
        }
        return catalog.get(Integer.valueOf(id)-1);
    }
    
    
    
}
