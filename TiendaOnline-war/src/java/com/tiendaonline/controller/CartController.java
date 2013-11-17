/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.ICart;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author josue
 */
public class CartController extends FrontCommand{
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
            
            forward("/carrito.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}