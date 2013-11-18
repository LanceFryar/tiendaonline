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
public class MainController extends FrontCommand {
    private static final String jndiCatalog = "java:global/TiendaOnline/TiendaOnline-ejb/Catalog!com.tiendaonline.interfacebeans.ICatalog";
    ICatalog catalog;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
//            properties.setProperty("org.omg.CORBA:ORBInitialHost", "localhost");
//            properties.setProperty("org.omg.CORBA:ORBInitialPort", "3700");
            Context initialContext = new InitialContext();
            
            catalog = (ICatalog) initialContext.lookup(jndiCatalog);
            
            response.setContentType("image/gif");
            response.setHeader("cache-control", "no-cache");
            request.setAttribute("catalog", catalog);
            forward("/main.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
