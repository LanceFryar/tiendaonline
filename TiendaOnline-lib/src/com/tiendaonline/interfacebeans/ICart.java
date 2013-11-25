/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.interfacebeans;

import com.tiendaonline.libraries.IProduct;
import java.util.ArrayList;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author josue
 */

@Local
public interface ICart {

    public void saveProducts();

    public void addProduct(IProduct product);

    public void empty();

    public void removeProduct(String id);
    
    public ArrayList<IProduct> getCart();
    
}
