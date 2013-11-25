/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.interfacebeans.ICart;
import java.io.IOException;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josue
 */
public abstract class FrontCommand {
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    
    public void init(HttpServletRequest request, 
            HttpServletResponse response,
            ServletContext context){
        this.request = request;
        this.response = response;
        this.context = context;
    }
    
    protected abstract void process();
    
    protected ICart getCart(HttpServletRequest request) throws NamingException {
        HttpSession session = request.getSession(true);
        ICart cart = (ICart) session.getAttribute("cart");
        if (cart==null) {
            Properties properties = new Properties();
            properties.setProperty("org.omg.CORBA:ORBInitialHost", "localhost");
            properties.setProperty("org.omg.CORBA:ORBInitialPort", "3700");

            cart = (ICart)new InitialContext().lookup("java:global/TiendaOnline/TiendaOnline-ejb/Cart!com.tiendaonline.interfacebeans.ICart");
            session.setAttribute("cart", cart);
        }
        return cart;
        
    }
    
    public void forward(String target){
        try {
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(target);
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ex){
            //TODO algo habrá que hacer
        }
    }
    
}
