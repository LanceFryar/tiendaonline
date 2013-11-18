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
    //private static final String jndiCatalog = "java:global/TiendaOnline-ejb/Catalog"; //Direccióm del GlassFish que no funciona
    private static final String jndiCatalog = "java:global/Catalog";
    ICatalog catalog;
    
    @Override
    protected void process() {
        try {
            Properties properties = new Properties();
            //properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            //properties.put("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            //properties.put("java.naming.provider.url", "localhost:1099");
//                properties.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");  
//                properties.put(Context.PROVIDER_URL,"t3://127.0.0.1:7001");  
            Context initialContext = new InitialContext(properties);
            
            catalog = (ICatalog) initialContext.lookup("Catalog");
            
            response.setContentType("image/gif");
            response.setHeader("cache-control", "no-cache");
            request.setAttribute("catalog", catalog);
            forward("/main.jsp");
        } catch (NamingException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
