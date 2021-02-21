package carsharing.ui;

import carsharing.dao.H2DaoUtils;

public class StartMenu extends BaseModelUI {

    public StartMenu() {
        H2DaoUtils.getCompanyDao().createTable();
        H2DaoUtils.getCarDao().createTable();
        while (!isExit) {
            logMenuShow();
        }
    }

    public void logMenuShow() {
        System.out.println("\n1. Log in as a manager");
        System.out.println("2. Log in as a customer");
        System.out.println("3. Create a customer");
        System.out.println("0. Exit");
        int i = scanner.nextInt();
                switch (i) {
                    case 0: {
                        isExit = true;
                        break;
                    }
                    case 1: {
                        new CompanyUI();
                        break;
                    }
                    default:
                        System.out.println("Unexpected value: " + i);
                }
    }
}
