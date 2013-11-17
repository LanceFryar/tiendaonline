/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.beans;

import com.tiendaonline.libraries.IProduct;
import javax.ejb.Remote;

/**
 *
 * @author josue
 */

public interface ICatalog {
    
    public IProduct getProduct(String id);
    
}
