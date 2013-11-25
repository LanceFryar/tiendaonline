/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.libraries.IAlbum;
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
public class AddProductController extends FrontCommand{
    private static final String jndiCatalog = "java:global/TiendaOnline/TiendaOnline-ejb/Catalog!com.tiendaonline.interfacebeans.ICatalog";
    ICatalog catalog;
    
    ICart cart;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
            properties.setProperty("org.omg.CORBA:ORBInitialHost", "localhost");
            properties.setProperty("org.omg.CORBA:ORBInitialPort", "3700");
            Context initialContext = new InitialContext();
            
            catalog = (ICatalog) initialContext.lookup(jndiCatalog);
            cart = getCart(request);
            
            String id = request.getParameter("id");
            if (id.split(":").length == 1) {
                cart.addProduct(catalog.getProduct(id));
            }
            else {
                IAlbum album = (IAlbum) catalog.getProduct(id.split(":")[0]);
                cart.addProduct(album.getSong(Integer.valueOf(id.split(":")[1])));
            }
            if (request.getParameter("from").equals("0")) {
                request.setAttribute("catalog", catalog);
                forward("/main.jsp");
            }
            else {
                request.setAttribute("album", catalog.getProduct(request.getParameter("from")));
                forward("/album.jsp");
            }
        } catch (NamingException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
