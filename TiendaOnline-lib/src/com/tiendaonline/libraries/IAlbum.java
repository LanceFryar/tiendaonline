/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.libraries;

import javax.ejb.Remote;

/**
 *
 * @author josue
 */
@Remote
public interface IAlbum extends IProduct{
    
    public String getCover();
    public ISong getSong(int track);
    
}
