/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.libraries;

import java.io.Serializable;
import javax.ejb.Remote;

/**
 *
 * @author josue
 */
@Remote
public interface ICatalog extends Serializable {
    public IProduct getProduct(String id);
    
}
