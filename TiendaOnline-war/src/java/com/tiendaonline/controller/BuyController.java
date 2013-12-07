/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.ICart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author YO
 */
public class BuyController extends FrontCommand{
    ICart cart;
    
    @Override
    protected void process() {
        try {
            
            cart = getCart(request);
            
            cart.saveProducts();
            cart.empty();
            request.setAttribute("cart", cart);
            forward("/carrito.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(BuyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
