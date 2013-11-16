/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.model;

import com.tiendaonline.libraries.IProduct;
import java.io.Serializable;

/**
 *
 * @author josue
 */
public class Product implements IProduct, Serializable{
    
    private String title;
    private String author;
    protected float price;

    public Product() {
    }

    public Product(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    
    
}
