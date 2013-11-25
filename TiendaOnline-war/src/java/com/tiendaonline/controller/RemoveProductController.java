/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.ICart;
import com.tiendaonline.interfacebeans.ICatalog;
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
public class RemoveProductController extends FrontCommand {
    private static final String jndiCatalog = "java:global/TiendaOnline/TiendaOnline-ejb/Catalog!com.tiendaonline.interfacebeans.ICatalog";
    ICatalog catalog;
    
    ICart cart;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
            properties.setProperty("org.omg.CORBA:ORBInitialHost", "localhost");
            properties.setProperty("org.omg.CORBA:ORBInitialPort", "3700");
            Context initialContext = new InitialContext(properties);
            
            catalog = (ICatalog) initialContext.lookup(jndiCatalog);
            cart = getCart(request);
            
            cart.removeProduct(request.getParameter("id"));
            request.setAttribute("cart", cart);
            
            forward("/carrito.jsp"); 
        } catch (NamingException ex) {
            Logger.getLogger(RemoveProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
