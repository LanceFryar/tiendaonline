/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.beans;

import javax.ejb.Stateful;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.libraries.ISaver;
import com.tiendaonline.loaders.FileSaver;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author josue
 */

@Stateful
@EJB(name="java:global/Cart", beanInterface=ICart.class)
public class Cart implements ICart{
    ArrayList<IProduct> cart;

    public Cart() {
        cart  = new ArrayList();
    }
    
    @Override
    public void saveProducts() {
        ISaver saver = new FileSaver();
        saver.saveCart(this);
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
    public void removeProduct(String id) {
        for (IProduct product : cart) {
            if (product.getId().equals(id)) {
                cart.remove(product);
            }
        }
    }

    @Override
    public ArrayList<IProduct> getCart() {
        return cart;
    }

}
