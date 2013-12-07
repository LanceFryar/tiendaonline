/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.IUser;
import com.tiendaonline.model.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Josué
 */
public class UserController extends FrontCommand {

    private static final String jndiUser = "java:global/TiendaOnline/TiendaOnline-per/UserMapper!com.tiendaonline.interfacebeans.IUser";
    private IUser user;

    @Override
    protected void process() {
        try {
            Context initialContext = new InitialContext();
            user = (IUser) initialContext.lookup(jndiUser);
            User logged = (User) session.getAttribute("user");
            
            ArrayList productList = user.findProductList(logged.getUsername());
            request.setAttribute("productList", productList);
            request.setAttribute("user", logged);
            
            forward("/userView.jsp");
            
        } catch (NamingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
