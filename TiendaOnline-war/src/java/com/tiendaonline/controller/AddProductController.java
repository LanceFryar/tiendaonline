/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.libraries.IAlbum;
import com.tiendaonline.beans.ICart;
import com.tiendaonline.beans.ICatalog;
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
    private static final String jndiCatalog = "java:global/TiendaOnline-ejb/Catalog";
    ICatalog catalog;
    
    private static final String jndiCart = "java:global/TiendaOnline-ejb/Cart";
    ICart cart;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
            properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            properties.put("java.naming.provider.url", "jnp://localhost:1099");
            Context context = new InitialContext(properties);
            
            catalog = (ICatalog) context.lookup(jndiCatalog);
            cart = (ICart) context.lookup(jndiCart);
            
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
