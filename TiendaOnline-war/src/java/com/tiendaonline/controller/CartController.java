/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

/**
 *
 * @author josue
 */
public class CartController extends FrontCommand{
    
     @Override
    protected void process() {
        forward("/carrito.jsp");
    }
    
}