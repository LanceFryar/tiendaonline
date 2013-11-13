/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.controller;

import com.tiendaonline.libraries.IAlbum;
import javax.ejb.EJB;

/**
 *
 * @author josue
 */
public class AlbumController extends FrontCommand{
    @EJB
    IAlbum album;
    
    @Override
    protected void process() {
//        ILoader loader = new FileLoader(context);
//        Album album = loader.loadAlbum(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("album", album);
        forward("/album.jsp");
    }
    
}
