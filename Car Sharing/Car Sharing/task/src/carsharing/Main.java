package carsharing;

import carsharing.dao.H2CompanyDao;
import carsharing.ui.DatabaseMenu;

public class Main {

    public static void main(String[] args) {
        DatabaseMenu databaseMenu = new DatabaseMenu();
//        H2CompanyDao h2CompanyDao = new H2CompanyDao();
//        h2CompanyDao.createTable();
        while (!databaseMenu.isExit()) {
            databaseMenu.logMenuShow();
        }

    }
}