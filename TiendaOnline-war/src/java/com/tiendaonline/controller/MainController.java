/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.libraries.ICatalog;
import com.tiendaonline.beans.Catalog;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author josue
 */
public class MainController extends FrontCommand{
    @EJB
    Catalog catalog;

    @Override
    protected void process() {
        try {
            catalog = (Catalog) new InitialContext().lookup("java:global/TiendaOnline-lib/ICatalog!com.tiendaonline.libraries.ICatalog");
        } catch (NamingException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (catalog == null) {
            catalog = new Catalog();
        }
        
        
        response.setContentType("image/gif");
        response.setHeader("cache-control", "no-cache"); 
        request.setAttribute("catalog", catalog);
        forward("/main.jsp");
    } 
}
