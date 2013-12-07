/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tiendaonline.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josué
 */
public abstract class AbstractMapper {
    protected Map loadedMap = new HashMap();

    abstract protected String findStatement();

    protected DomainObject abstractFind(Long id) {
        DomainObject result = loadedMap.get(id);
        if (result != null) {
            return result;
        }
        findResult = DB.prepare(findStatement());
        findResult.setLong(1, id);
        ResultSet rs = findResult.executeQuery();
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        result = load(rs);
        return result;
    }
    
    protected DomainObject load(ResultSet r) {
        Long id;
        try {
            id = new Long(r.getLong(1));
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        DomainObject result = loadedMap.get(id);
        if (result != null) {
            return result;
        }
        result = doLoad(id, r);
        loadedMap.put(id, result);
        return result;
    }

    abstract protected DomainObject doLoad(Long id, ResultSet rs);
}
