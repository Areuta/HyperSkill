package carsharing.dao;

import carsharing.model.BaseModel;
import carsharing.model.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static carsharing.dao.H2DaoUtils.*;

public class H2ModelDao implements ModelDao {
    protected static String CREATE;
    protected static String SELECT_ALL;
    protected static String SELECT;
    protected static String SELECT_ONE;
    protected static String INSERT;
    protected static String UPDATE;
    protected static String DELETE;


    @Override
    public void createTable() {
        executeUpdate(CREATE);
    }

    @Override
    public Long insertToTable(BaseModel model) {
        return null;
    }

    @Override
    public void clearTable(String nameTable) {
        DELETE = "DELETE FROM " + nameTable;
        executeUpdate(DELETE);
    }

    @Override
    public Company findInTable(Long id) {
        return null;
    }

    @Override
    public void updateModel(BaseModel model) {
    }

    @Override
    public List selectAll() {
        return selectWhere(SELECT_ALL);
    }

    @Override
    public List selectWhere(String where) {
        List<BaseModel> models = new ArrayList<>();
        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(where);
             ResultSet resultSet = pst.executeQuery()) {
            while (resultSet.next()) {
                models.add(fillModel(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;
    }

    @Override
    public BaseModel fillModel(ResultSet rs) throws SQLException {
        return null;
    }

    public void resetAuto_Increment(String nameTable) {
        executeUpdate("ALTER TABLE " +
                nameTable +
                " ALTER COLUMN id RESTART WITH 1");
    }


}
