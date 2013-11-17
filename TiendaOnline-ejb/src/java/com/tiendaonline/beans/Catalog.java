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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rayco
 */

@Stateless
@EJB(name="java:global/Catalog", beanInterface=ICatalog.class)
public class Catalog implements ICatalog{
    private ArrayList<IAlbum> catalog;

    public Catalog(){
        catalog = new ArrayList();
    }
    
    @PostConstruct
    void setCatalog () {
        ILoader fileLoader = new FileLoader();
        int i = 1;
        while (catalog.add(fileLoader.loadAlbum(""+i))) {
            i++;
        }
    }
    
    @Override
    public IProduct getProduct(String id) {
        return catalog.get(Integer.valueOf(id)-1);
    }
    
    
    
}
