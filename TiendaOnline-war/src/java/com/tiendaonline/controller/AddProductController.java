/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.libraries.IAlbum;
import com.tiendaonline.beans.ICart;
import com.tiendaonline.beans.ICatalog;
import javax.ejb.EJB;

/**
 *
 * @author YO
 */
public class AddProductController extends FrontCommand{
    @EJB
    ICart cart;
    
    @EJB
    ICatalog catalog;
    
    @Override
    protected void process() {
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
    }
    
}
