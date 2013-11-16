/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.libraries;
import java.io.Serializable;
/**
 *
 * @author josue
 */

public interface IProduct extends Serializable{ 
    public String getAuthor();
    public float getPrice();
    public String getTitle();
    
}
