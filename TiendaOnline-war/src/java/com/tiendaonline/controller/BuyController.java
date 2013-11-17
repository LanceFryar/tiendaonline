/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.beans.ICart;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author YO
 */
public class BuyController extends FrontCommand{
    //private static final String jndiCart = "java:global/TiendaOnline-ejb/Cart";
    private static final String jndiCart = "java:global/Cart";
    ICart cart;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            properties.put("java.naming.provider.url", "jnp://localhost:1099");
            Context initialContext = new InitialContext(properties);
            
            cart = (ICart) initialContext.lookup(jndiCart);
            
            cart.saveProducts();
            cart.empty();
            request.setAttribute("cart", cart);
            forward("/cart.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(BuyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
