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
        if (element.getIdParentElement() == null || element.getLabel().isEmpty()) {
            throw new ProjectException(ResultCode.INVALID_OBJECT, "A WBS element must have a parent element and a label");
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

            Clob description = db.getConnection().createClob();
            description.setString(1, element.getDescription());
            stmt.setClob(3, description);

            stmt.setBoolean(4, element.isIsWorkpackage());
            stmt.setTimestamp(5, new Timestamp(element.getStartDate().getTime()));
            stmt.setBigDecimal(6, element.getWorkload());
            stmt.setBigDecimal(7, element.getDuration());
            stmt.setBoolean(8, element.isIsContractual());

            Clob achievCriteria = db.getConnection().createClob();
            achievCriteria.setString(1, element.getAchievmentCriteria());
            stmt.setClob(9, achievCriteria);

            stmt.setTimestamp(10, new Timestamp(element.getDeliveryDate().getTime()));
            stmt.setBigDecimal(11, element.getLaborAmount());
            stmt.setBigDecimal(12, element.getPurchaseAmount());
            stmt.setBigDecimal(13, element.getExpenseAmount());
            stmt.setBigDecimal(14, element.getRentAmount());
            stmt.setBigDecimal(15, element.getSubcontractAmount());
            stmt.setTimestamp(16, new Timestamp(element.getEarlyStart().getTime()));
            stmt.setTimestamp(17, new Timestamp(element.getEarlyFinish().getTime()));
            stmt.setTimestamp(18, new Timestamp(element.getLateStart().getTime()));
            stmt.setTimestamp(19, new Timestamp(element.getLateFinish().getTime()));
            stmt.setBigDecimal(20, element.getTotalSlack());
            stmt.setBigDecimal(21, element.getFreeSlack());
            stmt.setLong(22, element.getIdParentElement());
            stmt.setInt(23, element.getRank());

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
    public boolean update(WBSElement obj) {
        return false;
    }

    @Override
    public WBSElement find(long id) throws DatabaseException {
        try {
            ResultSet response = db.executeRequest(
                    "SELECT element_id, element_label, element_description, element_isWorkpackage, element_start, "
                    + "element_workload, element_duration, element_isContractual, element_achievCriteria, element_delivDate, "
                    + "element_laborAmount, element_purchaseAmount, element_expenseAmount, element_rentAmount, element_subContrAmount, "
                    + "element_earlyStart, element_earlyFinish, element_lateStart, element_lateFinish, element_totalSlack, element_freeSlack, element_rank, project_id "
                    + "FROM projectDefinition.element "
                    + "WHERE element_id = " + id);

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
}
