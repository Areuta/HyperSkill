package carsharing.dao;

import carsharing.model.BaseModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static carsharing.dao.H2DaoUtils.executeUpdate;

public class H2ModelDao implements ModelDao {
    String CREATE;
    String SELECT_ALL;
    String SELECT_ONE;
    String SELECT_WHERE;
    String INSERT;
    String UPDATE;
    String DELETE;
    String RENTEDQUERY = "SELECT car.name, company.name FROM customer, company, car" +
            " WHERE car.company_id = company.id" +
            " AND customer.rented_car_id = car.id" +
            " AND customer.id = ?";


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
    public BaseModel findInTable(Long id) {
        BaseModel baseModel = null;
        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(SELECT_ONE)
        ) {
            pst.setLong(1, id);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                baseModel = fillModel(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baseModel;
    }

    @Override
    public void updateModel(BaseModel model) {
    }

    @Override
    public List<BaseModel> selectAll() {
        return selectWhere(SELECT_ALL);
    }

    @Override
    public List<BaseModel> selectWhere(String where) {
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
    // метод обнуляет автоинкрементный счётчик, если таблица пуста
    void resetAuto_Increment(String nameTable) {
        if (selectAll().isEmpty()) {
            executeUpdate("ALTER TABLE " +
                    nameTable +
                    " ALTER COLUMN id RESTART WITH 1");
        }
    }


}
