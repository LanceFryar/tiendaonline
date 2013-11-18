/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.ICatalog;
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
public class AlbumController extends FrontCommand{
    private static final String jndiCatalog = "java:global/TiendaOnline/TiendaOnline-ejb/Catalog!com.tiendaonline.interfacebeans.ICatalog";
    ICatalog catalog;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
            properties.setProperty("org.omg.CORBA:ORBInitialHost", "localhost");
            properties.setProperty("org.omg.CORBA:ORBInitialPort", "3700");
            Context initialContext = new InitialContext(properties);
            
            catalog = (ICatalog) initialContext.lookup(jndiCatalog);
            request.setAttribute("album", catalog.getProduct(request.getParameter("id")));
            forward("/album.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
