/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.beans;

import javax.ejb.Stateful;
import com.tiendaonline.libraries.ICart;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.model.Product;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author josue
 */

@Stateful
public class Cart implements ICart{
    ArrayList<IProduct> cart = new ArrayList();

    @Override
    public void saveProducts() {
        
    }

    @Override
    public void addProduct(IProduct product) {
        cart.add(product);
    }

    @Override
    public void empty() {
        cart.clear();
    }

    @Override
    public void removeProduct(IProduct product) {
        cart.remove(product);
    }
    
}
