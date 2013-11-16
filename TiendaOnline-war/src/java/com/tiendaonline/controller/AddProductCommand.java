/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.libraries.ICart;
import com.tiendaonline.libraries.ICatalog;
import javax.ejb.EJB;

/**
 *
 * @author YO
 */
public class AddProductCommand extends FrontCommand{
    @EJB
    ICart cart;
    
    @EJB
    ICatalog catalog;
    
    @Override
    protected void process() {
        cart.addProduct(catalog.getProduct(request.getParameter("id")));
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
