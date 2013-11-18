/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.ICart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author josue
 */
public class CartController extends FrontCommand{
    ICart cart;
    
    @Override
    protected void process() {
        try {

            cart = getCart(request);
            
            forward("/carrito.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}