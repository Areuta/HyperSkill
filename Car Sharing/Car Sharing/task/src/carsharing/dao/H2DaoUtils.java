package carsharing.dao;

import java.sql.*;
import java.util.Objects;

public class H2DaoUtils {

    // JDBC driver name and database URL
    static Connection connection = null;
    private static H2CompanyDao h2CompanyDao = null;
    private static H2CarDao h2CarDao = null;
    private static H2CustomerDao h2CustomerDao = null;
    static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String databasePath = "./src/carsharing/db/";
    private static final String databaseFileName = "carsharing";
    static String DB_URL = "jdbc:h2:./src/carsharing/db/carsharing";

    // database connection
    public static Connection getConnection() {
        try {
            if (connection != null && !connection.isClosed())
                return connection;

            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet executeQuery(String query) {
        try (ResultSet resultSet = getConnection().createStatement().executeQuery(query)){
            return resultSet;
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
        return Objects.requireNonNullElseGet(h2CompanyDao, H2CompanyDao::new);
    }

    public static H2CarDao getCarDao() {
        return Objects.requireNonNullElseGet(h2CarDao, H2CarDao::new);
    }

    public static H2CustomerDao getH2CustomerDao() {
        return Objects.requireNonNullElseGet(h2CustomerDao, H2CustomerDao::new);
    }
}
