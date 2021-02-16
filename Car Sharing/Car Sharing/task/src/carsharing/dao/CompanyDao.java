package carsharing.dao;

import carsharing.model.BaseModel;
import carsharing.model.Company;

import java.util.Collection;

public interface CompanyDao {
    void createTable(); // создание таблицы

    Long insertCompany(BaseModel model);

    boolean deleteCompany(BaseModel model);

    Company findCompany(BaseModel model);

    boolean updateCompany(BaseModel model);

    Collection selectCompanysTO();

//    void createForeignKeys() throws SQLException; // создание связей между таблицами

    //        RowSet selectCompanysRS(BaseModel model);

}

