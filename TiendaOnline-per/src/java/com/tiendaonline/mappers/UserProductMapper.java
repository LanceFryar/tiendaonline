/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.mappers;

import com.tiendaonline.interfacebeans.ICart;
import com.tiendaonline.libraries.ISaver;
import javax.ejb.Stateless;

/**
 *
 * @author Josué
 */
@Stateless
public class UserProductMapper implements ISaver {

    @Override
    public void saveCart(ICart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
