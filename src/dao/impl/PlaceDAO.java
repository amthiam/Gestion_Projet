
package dao.impl;

import dao.DAO;
import exceptions.ProjectException;
import manager.DatabaseManager;
import model.Place;

/**
 * Implementation of the abstract DAO class Class used to create, update, find
 * and delete information about places in the database
 * @author Felix
 */
public class PlaceDAO extends DAO<Place> {
    
    /**
     * Constructor
     *
     * @param db : database manager providing a connection to the database
     */
    public PlaceDAO(DatabaseManager db) {
        super(db);
    }

    @Override
    public Long create(Place obj) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Place obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Place obj) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Place find(long id) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
