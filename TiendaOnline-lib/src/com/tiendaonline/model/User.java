/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.model;

import java.io.Serializable;

/**
 *
 * @author Josué
 */
public class User implements Serializable{
    
    private String name;
    private String username;
    private String password;

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    
}
