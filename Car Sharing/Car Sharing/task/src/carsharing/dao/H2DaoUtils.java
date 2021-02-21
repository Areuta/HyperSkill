package carsharing.dao;

import java.sql.*;

public class H2DaoUtils {

    // JDBC driver name and database URL
    static Connection connection = null;
    private static H2CompanyDao h2CompanyDao = null;
    private static H2CarDao h2CarDao = null;
    private static H2CustomerDao h2CustomerDao = null;
    static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String databasePath = "./src/carsharing/db/";
    private static String databaseFileName = "carsharing";
    static String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";

    // database connection
    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed())
                return connection;

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

    public static ResultSet executeQuery(String query) {
        try {
            return getConnection().createStatement().executeQuery(query);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static void executeUpdate(String query) {
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public static H2CompanyDao getCompanyDao() {
        if (h2CompanyDao != null){
            return h2CompanyDao;
        }else {
            return new H2CompanyDao();
        }
    }

    public static H2CarDao getCarDao() {
        if (h2CarDao != null){
            return h2CarDao;
        }else {
            return new H2CarDao();
        }
    }

    public static H2CustomerDao getH2CustomerDao() {
        if(h2CustomerDao != null) {
            return h2CustomerDao;
        }else {
            return new H2CustomerDao();
        }
    }
}
