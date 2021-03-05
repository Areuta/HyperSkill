package banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtils {
    //    JDBC    driver    name    and    database    URL
    static Connection connection = null;
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String databasePath = "";
    private static String databaseFileName = "card.s3db";
    static String DB_URL = "jdbc:sqlite:" + databasePath + databaseFileName;


    public static ModelDao setAccountDao(String dataBase) {
        if (dataBase.equals("Array")) {
            return new ArrayAccountDao();
        }
        if (dataBase.equals("Sqlite")) {
            return new SqlLIteAccountDao();
        }
        return null;
    }

    public static void setDatabaseFileName(String databaseFileName) {
        DaoUtils.databaseFileName = databaseFileName;
        DB_URL = "jdbc:sqlite:" + databasePath + databaseFileName;
    }

    // close connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //    database    connection
    public static Connection getConnection() {
//        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
//        sqLiteDataSource.setUrl(DB_URL);

        try {
            if (connection == null || connection.isClosed()) {
//                connection = sqLiteDataSource.getConnection();
                connection = DriverManager.getConnection(DB_URL);
                return connection;
            }
//            Class.forName(JDBC_DRIVER);
//            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void executeUpdate(String query) {
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}
