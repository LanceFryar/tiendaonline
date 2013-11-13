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
public interface ISong extends IProduct{
    
    public int getPosition();

    public int getMinutes();

    public int getSeconds();
    
}
