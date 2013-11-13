/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    
    public void forward(String target){
        try {
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(target);
            requestDispatcher.forward(request, response);
        } catch (IOException | ServletException ex){
            //TODO algo habrá que hacer
        }
    }
    
}
