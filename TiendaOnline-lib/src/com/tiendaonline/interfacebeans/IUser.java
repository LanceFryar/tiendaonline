/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.interfacebeans;

import com.tiendaonline.model.Product;
import com.tiendaonline.model.User;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Josué
 */
@Remote
public interface IUser {
    
    public User find(String username, String password);
    public ArrayList<Product> findProductList(String username);
    
}
