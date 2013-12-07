/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.mappers;

import com.tiendaonline.interfacebeans.IUser;
import com.tiendaonline.model.Product;
import com.tiendaonline.model.User;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author Josué
 */
@Stateless
public class UserMapper implements IUser {

    @Override
    public User find(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Product> findProductList(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
