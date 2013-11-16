/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.beans.ICatalog;
import javax.ejb.EJB;


/**
 *
 * @author josue
 */
public class MainController extends FrontCommand {
    @EJB
    ICatalog catalog;

    @Override
    protected void process() {        
        catalog.getProduct("1");
            
        response.setContentType("image/gif");
        response.setHeader("cache-control", "no-cache");
        request.setAttribute("catalog", catalog);
        forward("/main.jsp");
    } 
}
