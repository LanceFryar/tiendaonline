/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.loaders;

import com.tiendaonline.interfacebeans.ICart;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.libraries.ISaver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author YO
 */
public class FileSaver implements ISaver{

    @Override
    public void saveCart(ICart cart) {
        float bill = 0;
        try {
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("/"+new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis()))));
            for (IProduct product : cart.getCart()) {
                bill += product.getPrice();
                writer.write(product.getTitle()+" - "+product.getAuthor()+": "+product.getPrice());
                writer.newLine();
            }
            writer.newLine();
            writer.write("Total: "+bill);
            writer.close();
        }
        catch (Exception exception) {}
    }
}
