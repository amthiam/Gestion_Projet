package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import exceptions.ResultCode;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import manager.DatabaseManager;
import model.WBSElement;

/**
 * Implementation of the abstract DAO class Class used to create, update, find
 * and delete information about WBS element in the database
 *
 * @author Felix
 */
public class WBSElementDAO extends DAO<WBSElement> {

    /**
     * Constructor
     *
     * @param db : database manager providing a connection to the database
     */
    public WBSElementDAO(DatabaseManager db) {
        super(db);
    }

    @Override
    public Long create(WBSElement element) throws ProjectException {

        // The fields idParentElement and element_label are compulsory in the database
        if (element.getLabel().isEmpty()) {
            throw new ProjectException(ResultCode.INVALID_OBJECT, "A WBS element must have a label");
        }

        //Insertion in the database
        try {

            db.startTransaction();

            // SQL query
            String sql = "INSERT INTO projectDefinition.element "
                    + "(project_id, element_label, element_description, element_isWorkpackage, element_start, element_workload, element_duration, element_isContractual, "
                    + "element_achievCriteria, element_delivDate, element_laborAmount, element_purchaseAmount, element_expenseAmount, element_rentAmount, element_subContrAmount, "
                    + "element_earlyStart, element_earlyFinish, element_lateStart, element_lateFinish, element_totalSlack, element_freeSlack, Parent_element_id, element_rank) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //Creation of the sql statement
            PreparedStatement stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, element.getIdProject());
            stmt.setString(2, element.getLabel());

            // Field description is optional
            if (element.isNull("description")) {
                stmt.setNull(3, java.sql.Types.CLOB);
            } else {
                Clob description = db.getConnection().createClob();
                description.setString(1, element.getDescription());
                stmt.setClob(3, description);
            }

            stmt.setBoolean(4, element.isIsWorkpackage());

            // Field startDate is optional
            if (element.isNull("startDate")) {
                stmt.setNull(5, java.sql.Types.TIMESTAMP);
            } else {
                stmt.setTimestamp(5, new Timestamp(element.getStartDate().getTime()));
            }

            // Field workload is optional
            if (element.isNull("workload")) {
                stmt.setNull(6, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(6, element.getWorkload());
            }

            // Field duration is optional
            if (element.isNull("duration")) {
                stmt.setNull(7, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(7, element.getDuration());
            }

            stmt.setBoolean(8, element.isIsContractual());

            // Field achievmentCriteria is optional
            if (element.isNull("achievmentCriteria")) {
                stmt.setNull(9, java.sql.Types.CLOB);
            } else {
                Clob achievCriteria = db.getConnection().createClob();
                achievCriteria.setString(1, element.getAchievmentCriteria());
                stmt.setClob(9, achievCriteria);
            }

            // Field deliveryDate is optional
            if (element.isNull("deliveryDate")) {
                stmt.setNull(10, java.sql.Types.TIMESTAMP);
            } else {
                stmt.setTimestamp(10, new Timestamp(element.getDeliveryDate().getTime()));
            }

            // Field laborAmount is optional
            if (element.isNull("laborAmount")) {
                stmt.setNull(11, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(11, element.getLaborAmount());
            }

            // Field pruchaseAmount is optional
            if (element.isNull("purchaseAmount")) {
                stmt.setNull(12, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(12, element.getPurchaseAmount());
            }

            // Field expenseAmount is optional
            if (element.isNull("expenseAmount")) {
                stmt.setNull(13, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(13, element.getExpenseAmount());
            }

            // Field rentAmount is optional
            if (element.isNull("rentAmount")) {
                stmt.setNull(14, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(14, element.getRentAmount());
            }

            // Field subcontractAmount is optional
            if (element.isNull("subcontractAmount")) {
                stmt.setNull(15, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(15, element.getSubcontractAmount());
            }

            // Field earlyStart is optional
            if (element.isNull("earlyStart")) {
                stmt.setNull(16, java.sql.Types.TIMESTAMP);
            } else {
                stmt.setTimestamp(16, new Timestamp(element.getEarlyStart().getTime()));
            }

            // Field earlyFinish is optional
            if (element.isNull("earlyFinish")) {
                stmt.setNull(17, java.sql.Types.TIMESTAMP);
            } else {
                stmt.setTimestamp(17, new Timestamp(element.getEarlyFinish().getTime()));
            }

            // Field lateStart is optional
            if (element.isNull("lateStart")) {
                stmt.setNull(18, java.sql.Types.VARCHAR);
            } else {
                stmt.setTimestamp(18, new Timestamp(element.getLateStart().getTime()));
            }

            // Field lateFinish is optional
            if (element.isNull("lateFinish")) {
                stmt.setNull(19, java.sql.Types.TIMESTAMP);
            } else {
                stmt.setTimestamp(19, new Timestamp(element.getLateFinish().getTime()));
            }

            // Field totalSlack is optional
            if (element.isNull("totalSlack")) {
                stmt.setNull(20, java.sql.Types.VARCHAR);
            } else {
                stmt.setBigDecimal(20, element.getTotalSlack());
            }

            // Field freeSlack is optional
            if (element.isNull("freeSlack")) {
                stmt.setNull(21, java.sql.Types.VARCHAR);
            } else {
                stmt.setBigDecimal(21, element.getFreeSlack());
            }

            // Field idParentElement is optional
            if (element.isNull("idParentElement")) {
                stmt.setNull(22, java.sql.Types.BIGINT);
            } else {
                stmt.setLong(22, element.getIdParentElement());
            }

            // Field rank is optional
            if (element.isNull("rank")) {
                stmt.setNull(23, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(23, element.getRank());
            }

            //Execution of the query
            stmt.executeUpdate();

            // Retrieve the id of the element just created
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "The creation of the element failed");
            }
            Long idElement = generatedKeys.getLong(1);

            db.commit();

            return idElement;

        } catch (SQLException e) {
            throw new DatabaseException(e);
        }



    }

    @Override
    public boolean delete(WBSElement obj) {
        return false;
    }

    @Override
    public void update(WBSElement obj) throws DatabaseException {
    }

    @Override
    public WBSElement find(long id) throws DatabaseException {
        try {

            ResultSet response = db.executeRequest(
                    "SELECT element_id, element_label, element_description, element_isWorkpackage, element_start, "
                    + "element_workload, element_duration, element_isContractual, element_achievCriteria, element_delivDate, "
                    + "element_laborAmount, element_purchaseAmount, element_expenseAmount, element_rentAmount, element_subContrAmount, "
                    + "element_earlyStart, element_earlyFinish, element_lateStart, element_lateFinish, element_totalSlack, element_freeSlack, element_rank, project_id, Parent_element_id "
                    + "FROM projectDefinition.element "
                    + "WHERE element_id = " + id);

            

            if (!response.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "Object not found");
            }

            Long idElement = response.getLong("element_id");
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
            Long idParentElement = response.getLong("Parent_element_id");
            Integer rank = response.getInt("element_rank");
            Long idProject = response.getLong("project_id");

            String description = descriptionCl.getSubString(1, (int) descriptionCl.length());
            String achievCriteria = achievCriteriaCl.getSubString(1, (int) achievCriteriaCl.length());

            WBSElement result = new WBSElement(idElement, label, description, isWorkpackage, startDate, workload, duration, isContractual, achievCriteria, delivDate, laborAmount, purchaseAmount, expenseAmount, rentAmount, subcontractAmount, earlyStart, earlyFinish, lateStart, lateFinish, totalSlack, freeSlack, idParentElement, rank, idProject);

            return result;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }


    }
    
    /**
     * Method returning the list of WBS Element stored in the database concerning a given project
     * @param projectId : id of the project 
     * @return the list of element 
     */
    public LinkedList<WBSElement> ListElementFromProject(long projectId) throws ProjectException{
        
        LinkedList<WBSElement> resultList = new LinkedList();
        
        //Query into the database to return the list of id of WBS element.
        try{
            
            ResultSet response = db.executeRequest(
                    "SELECT element_id FROM project WHERE project_id = " + projectId);
            
            //Creating the WBSElement objects from the list of ids found, and adding them to the result list
            while(response.next()){
                Long elementId = response.getLong("element_id");
                WBSElement element = find(elementId);
                resultList.add(element);
                
            }
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
        return resultList;
    }
}
