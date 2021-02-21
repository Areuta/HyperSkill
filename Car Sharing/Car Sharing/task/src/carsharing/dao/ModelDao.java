package carsharing.dao;

import carsharing.model.BaseModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ModelDao {
    void createTable(); // создание таблицы

    Long insertToTable(BaseModel model);

    void clearTable(String nameTable);

    BaseModel findInTable(Long id);

    void updateModel(BaseModel model);

    List selectAll();

    List selectWhere(String where);

    BaseModel fillModel(ResultSet rs) throws SQLException;


}

