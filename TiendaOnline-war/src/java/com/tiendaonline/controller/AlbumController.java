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
public class AlbumController extends FrontCommand{
    @EJB
    ICatalog catalog;
    
    @Override
    protected void process() {
        request.setAttribute("album", catalog.getProduct(request.getParameter("id")));
        forward("/album.jsp");
    }
    
}
