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
public interface IProduct {
    
    public String getAuthor();
    public float getPrice();
    public String getTitle();
    
}
