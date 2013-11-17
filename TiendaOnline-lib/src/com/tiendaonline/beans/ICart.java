/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.beans;

import com.tiendaonline.libraries.IProduct;
import java.util.ArrayList;

/**
 *
 * @author josue
 */

public interface ICart {

    public void saveProducts();

    public void addProduct(IProduct product);

    public void empty();

    public void removeProduct(String id);
    
    public ArrayList<IProduct> getCart();
    
}
