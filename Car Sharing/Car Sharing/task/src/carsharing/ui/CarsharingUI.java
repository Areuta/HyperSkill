package carsharing.ui;

import carsharing.dao.H2CustomerDao;
import carsharing.dao.H2DaoUtils;
import carsharing.model.Customer;

import java.util.List;

public class CarsharingUI extends BaseModelUI {
    private H2CustomerDao h2CustomerDao;

    public CarsharingUI() {
        H2DaoUtils.getCompanyDao().createTable();
        H2DaoUtils.getCarDao().createTable();
        H2DaoUtils.getH2CustomerDao().createTable();
        h2CustomerDao = H2DaoUtils.getH2CustomerDao();

        while (!isExit) {
            modelMenuShow("Customer");
            modelMenuProcess();
        }
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
                new CompanyUI(isCustomer);
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
                System.out.println("Unexpected value: " + i);
        }
    }

    @Override
    public void modelsListMenuShow() {
        System.out.println();
        List<Customer> list = h2CustomerDao.selectAll();
        if (list.isEmpty()) {
            System.out.println("The customer list is empty!");
        } else {
            System.out.println("Customer list:");
            list.stream().forEach(System.out::println);
            System.out.println("0. Back");
        }
    }

    @Override
    public void modelsListMenuProcess() {
        long l = scanner.nextLong();
        if (l == 0) {
            return;
        }

        Customer customer = h2CustomerDao.findInTable(l);
        if (customer != null) {
            //todo add CustomerUI here
//              new CustomerUI2();
//            rentMenuShow();
//            rentMenuProcess();
        } else {
            System.out.println("There is no such customer!");
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
