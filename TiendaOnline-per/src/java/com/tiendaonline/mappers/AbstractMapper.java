package com.tiendaonline.mappers;

import com.tiendaonline.model.DomainObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        DomainObject result = (DomainObject) loadedMap.get(id);

        if (result != null) {
            return result;
        }

        try {
            Connection DB = DriverManager.getConnection("jdbc:derby:tiendaonline-db",
                    "tiendaonline",
                    "tiendaonline");
            PreparedStatement findStatement = null;
            findStatement = DB.prepareCall(findStatement());
            findStatement.setLong(1, id.longValue());
            ResultSet resultSet = findStatement.executeQuery();
            resultSet.next();
            result = load(resultSet);
            
        } catch (SQLException e) {
            // Ya haremos algo
        }
        return result;
        
    }
    
    protected DomainObject load(ResultSet r) {
        Long id = null;
        try {
            id = new Long(r.getLong(1));
        } catch (SQLException ex) {
            Logger.getLogger(AbstractMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        DomainObject result = (DomainObject) loadedMap.get(id);
        if (result != null) {
            return result;
        }
        result = doLoad(id, r);
        loadedMap.put(id, result);
        return result;
    }

    abstract protected DomainObject doLoad(Long id, ResultSet rs);
}
