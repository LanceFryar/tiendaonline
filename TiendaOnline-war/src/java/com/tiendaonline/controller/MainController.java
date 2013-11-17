/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.beans.Catalog;
import com.tiendaonline.beans.ICatalog;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 *
 * @author josue
 */
public class MainController extends FrontCommand {
    
    @EJB
    ICatalog catalog;
    
    @Override
    protected void process() {        
            
            response.setContentType("image/gif");
            response.setHeader("cache-control", "no-cache");
            request.setAttribute("catalog", catalog);
            forward("/main.jsp");
    }
}
