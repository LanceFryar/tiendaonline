/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.libraries.ICatalog;
import javax.ejb.EJB;


/**
 *
 * @author josue
 */
public class MainController extends FrontCommand{
    @EJB
    ICatalog catalog;

    @Override
    protected void process() {
        /*try {
            catalog = (Catalog) new InitialContext().lookup("java:global/TiendaOnline-lib/ICatalog!com.tiendaonline.libraries.ICatalog");
        } catch (NamingException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        catalog.getProduct("1");
        
        response.setContentType("image/gif");
        response.setHeader("cache-control", "no-cache"); 
        request.setAttribute("catalog", catalog);
        forward("/main.jsp");
    } 
}
