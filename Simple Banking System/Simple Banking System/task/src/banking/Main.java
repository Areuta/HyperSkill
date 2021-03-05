package banking;

import banking.ui.LoginUI;

import static banking.dao.DaoUtils.setDatabaseFileName;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2 && args[0].equals("-fileName")) {
            setDatabaseFileName(args[1]);
        }

        new LoginUI("Sqlite");
//        new LoginUI("Array");
    }
}

