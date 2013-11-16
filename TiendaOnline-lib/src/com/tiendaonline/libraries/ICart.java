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
public interface ICart {

    public void saveProducts();

    public void addProduct(IProduct product);

    public void empty();

    public void removeProduct(IProduct product);
    
}
