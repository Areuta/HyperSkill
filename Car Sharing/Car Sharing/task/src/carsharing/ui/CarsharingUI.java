package carsharing.ui;

import carsharing.dao.H2DaoUtils;
import carsharing.model.Customer;

import java.util.InputMismatchException;

public class CarsharingUI extends BaseModelUI {

    public CarsharingUI() {
        // создаём таблицы или проверяем их наличие
        H2DaoUtils.getCompanyDao().createTable();
        H2DaoUtils.getCarDao().createTable();
        H2DaoUtils.getH2CustomerDao().createTable();

        h2CustomerDao = H2DaoUtils.getH2CustomerDao();

        while (!isExit) {
            modelMenuShow("Customer");
            try {
                modelMenuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    @Override
    public void modelMenuShow(String nameModel) {
        System.out.println("\n1. Log in as a manager");
        System.out.println("2. Log in as a customer");
        System.out.println("3. Create a customer");
        System.out.println("0. Exit");
    }

    @Override
    public void modelMenuProcess() {
        int i = scanner.nextInt();
        switch (i) {
            case 0: {
                isExit = true;
                break;
            }
            case 1: {
                isCustomer = false;
                new CompanyUI(false);
                break;
            }
            case 2: {
                isCustomer = true;
                new CustomerUI();
                break;
            }
            case 3: {
                addModel();
                break;
            }
            default:
                System.out.println(badInput + i);
        }
    }


    @Override
    public void addModel() {
        System.out.println("\nEnter the customer name:");
        scanner.nextLine();
        h2CustomerDao = H2DaoUtils.getH2CustomerDao();
        Customer customer = new Customer(scanner.nextLine());
        if (h2CustomerDao.insertToTable(customer) != -1) {
            System.out.println("The customer was added!");
        }
    }
}
