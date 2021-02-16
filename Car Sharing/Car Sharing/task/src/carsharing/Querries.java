package carsharing;

public class Querries {

    public static final String strCreateTable = "CREATE TABLE COMPANY (ID INTEGER, NAME VARCHAR);";
    public static final String strAlterTableID = "ALTER TABLE COMPANY ALTER COLUMN ID INT NOT NULL AUTO_INCREMENT;";
    public static final String strAlterTablePK = "ALTER TABLE COMPANY ADD CONSTRAINT pk_id PRIMARY KEY (ID);";
    public static final String strAlterTableNameN0 = "ALTER TABLE COMPANY ALTER COLUMN NAME VARCHAR NOT NULL;";
    public static final String strAlterTableNameUn = "ALTER TABLE COMPANY ADD UNIQUE (NAME);";
    public static final String strSelectAll = "SELECT * FROM COMPANY;";
    public static final String strShow = "SHOW TABLES;";
}
