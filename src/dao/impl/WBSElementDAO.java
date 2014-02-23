
package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.DatabaseManager;
import model.WBSElement;

/**
 * Implementation of the abstract DAO class
 * Class used to create, update, find and delete information about WBS element in the database
 * @author Felix
 */
public class WBSElementDAO extends DAO<WBSElement> {
    
    public WBSElementDAO(DatabaseManager db){
        super(db);
    }
    
    public boolean create(WBSElement obj){
    return false;
  }

  public boolean delete(WBSElement obj){
    return false;
  }
   
  public boolean update(WBSElement obj){
    return false;
  }
  
    @Override
  public WBSElement find(long id) throws DatabaseException {
      try{
      ResultSet response = db.executeRequest(
              "SELECT element_id, element_label, element_description, element_isWorkpackage, element_start" +
              "element_workload, element_duration, element_isContractual, element_achievCriteria, element_delivDate" +
              "element_laborAmount, element_purchaseAmount, element_expenseAmount, element_rentAmount, element_subContrAmount" +
              "element_earlyStart, element_earlyFinish, element_lateStart, element_lateFinish, element_totalSlack, element_freeSlack, element_rank" +
              "FROM projectDefinition.element" +
              "WHERE element_id="+id);
      
      int idElement = response.getInt("element_id");
      String label = response.getString("element_label");
      Clob descriptionCl = response.getClob("element_description");
      boolean isWorkpackage = response.getBoolean("element_isWorkpackage");
      Date startDate = response.getTimestamp("element_start");
      BigDecimal workload = response.getBigDecimal("element_workload");
      BigDecimal duration = response.getBigDecimal("element_duration");
      boolean isContractual = response.getBoolean("element_isContractual");
      Clob achievCriteriaCl = response.getClob("element_achievCriteria");
      Date delivDate = response.getTimestamp("element_delivDate");
      BigDecimal laborAmount = response.getBigDecimal("element_laborAmount");
      BigDecimal purchaseAmount = response.getBigDecimal("element_purchaseAmount");
      BigDecimal expenseAmount = response.getBigDecimal("element_expenseAmount");
      BigDecimal rentAmount = response.getBigDecimal("element_rentAmount");
      BigDecimal subcontractAmount = response.getBigDecimal("element_subContrAmount");
      Date earlyStart = response.getTimestamp("element_earlyStart");
      Date earlyFinish = response.getTimestamp("element_earlyFinish");
      Date lateStart = response.getTimestamp("element_lateStart");
      Date lateFinish = response.getTimestamp("element_lateFinish");
      BigDecimal totalSlack = response.getBigDecimal("element_totalSlack");
      BigDecimal freeSlack = response.getBigDecimal("element_freeSlack");
      long idParentElement = response.getLong("Parent_element_id");
      int rank = response.getInt("element_rank");
      
      String description = descriptionCl.getSubString(1, (int) descriptionCl.length());
      String achievCriteria = achievCriteriaCl.getSubString(1, (int) achievCriteriaCl.length());
      
      WBSElement result = new WBSElement(idElement, label, description, isWorkpackage, startDate, workload, duration, isContractual, achievCriteria, delivDate, laborAmount, purchaseAmount, expenseAmount, rentAmount, subcontractAmount, earlyStart, earlyFinish, lateStart, lateFinish, totalSlack, freeSlack, idParentElement, rank);
         
      return result;
      }
      
      catch (SQLException e){
          throw new DatabaseException(e);          
      }
      
      
  }

   
}
