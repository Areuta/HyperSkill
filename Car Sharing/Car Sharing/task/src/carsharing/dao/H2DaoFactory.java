package carsharing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DaoFactory {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String databasePath = "./src/carsharing/db/";
    private static String databaseFileName = "carsharing";
    static String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";

    // database connection
    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public CompanyDao getCustomerDao() {
        return new H2CompanyDao();
    }

}
