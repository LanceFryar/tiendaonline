/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.libraries;

import com.tiendaonline.interfacebeans.ICart;
import javax.ejb.Remote;

/**
 *
 * @author YO
 */
@Remote
public interface ISaver {
    public void saveCart(ICart cart);
}
