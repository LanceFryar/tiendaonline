/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

/**
 *
 * @author Josué
 */
public class LogoutController extends FrontCommand{
    
    

    @Override
    protected void process() {
        session.setAttribute("user", null);
        if (request.getParameter("from").equals("0")) {
            forward("/main.jsp");
        } else {
            forward("/album.jsp");
        }
    }
    
}
