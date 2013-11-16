/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.beans.ICart;
import javax.ejb.EJB;

/**
 *
 * @author YO
 */
public class BuyController extends FrontCommand{
    @EJB
    ICart cart;
    
    @Override
    protected void process() {
        cart.saveProducts();
        cart.empty();
        request.setAttribute("cart", cart);
        forward("/cart.jsp");
    }
    
}
