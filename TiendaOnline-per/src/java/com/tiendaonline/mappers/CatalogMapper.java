/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.mappers;

import com.tiendaonline.interfacebeans.ICatalog;
import com.tiendaonline.libraries.IProduct;
import com.tiendaonline.model.DomainObject;
import java.sql.ResultSet;
import javax.ejb.Stateless;

/**
 *
 * @author Josué
 */
@Stateless
public class CatalogMapper extends AbstractMapper implements ICatalog {

    @Override
    public IProduct getProduct(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String findStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected DomainObject doLoad(Long id, ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
