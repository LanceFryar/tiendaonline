/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.model;

import com.tiendaonline.libraries.ICatalog;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.loaders.FileLoader;
import com.tiendaonline.loaders.ILoader;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Rayco
 */
@Stateless(name="CatalogBean")
public class Catalog implements ICatalog, Serializable{

    @Override
    public IProduct getProduct(String id) {
        ILoader loader = new FileLoader();
        IProduct product = loader.loadAlbum(id);
        return product;
    }
    
    
    
}
