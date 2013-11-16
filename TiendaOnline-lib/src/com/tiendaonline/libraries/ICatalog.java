/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.libraries;

import javax.ejb.Remote;

/**
 *
 * @author josue
 */

@Remote
public interface ICatalog {
    
    
    
    public IProduct getProduct(String id);
    
}
