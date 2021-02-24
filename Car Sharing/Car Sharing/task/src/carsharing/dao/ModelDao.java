package carsharing.dao;

import carsharing.model.BaseModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ModelDao {
    void createTable(); // создание таблицы

    Long insertToTable(BaseModel model);// вставка в таблицу новой строки

    void clearTable(String nameTable); // очистить таблицу

    BaseModel findInTable(Long id); // найти в таблице строку по id

    void updateModel(BaseModel model); // найти строку по id и заполнить значениями
                                       // взятыми из модели
    List<BaseModel> selectAll();  // получить все строки из таблицы

    List<BaseModel> selectWhere(String where); // получить все строки удовлетворяющие
                                               // условию в строке where
    BaseModel fillModel(ResultSet rs) throws SQLException; // заполнить модель данными
                                                    // полученными из resultset


}

