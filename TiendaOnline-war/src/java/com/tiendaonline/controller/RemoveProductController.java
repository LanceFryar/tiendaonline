/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.beans.ICart;
import com.tiendaonline.beans.ICatalog;
import javax.ejb.EJB;

/**
 *
 * @author YO
 */
public class RemoveProductController extends FrontCommand{
    @EJB
    ICart cart;
    
    @EJB
    ICatalog catalog;
    
    @Override
    protected void process() {
        cart.removeProduct(request.getParameter("id"));
        request.setAttribute("cart", cart);
    }
    
}
