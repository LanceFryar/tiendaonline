/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.IUser;
import com.tiendaonline.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Josué
 */
public class LoginController extends FrontCommand{
    private static final String jndiUser = "java:global/TiendaOnline/TiendaOnline-per/UserMapper!com.tiendaonline.interfacebeans.IUser";
    private IUser user;
    
    @Override
    protected void process() {
        try {
            Context initialContext = new InitialContext();
            user = (IUser) initialContext.lookup(jndiUser);
            
            User logged = user.find(request.getParameter("username"), 
                    request.getParameter("password"));
            if (logged == null){
                // ¿Qué coño hacemos si el loggin es incorrecto?
            }
            session.setAttribute("user", logged);
            if (request.getParameter("from").equals("0")) {
                forward("/main.jsp");
            }
            else {
                forward("/album.jsp");
            }
        } catch (NamingException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
