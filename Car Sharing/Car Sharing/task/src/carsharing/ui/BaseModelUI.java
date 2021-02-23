package carsharing.ui;

import carsharing.dao.H2CarDao;
import carsharing.dao.H2CompanyDao;
import carsharing.dao.H2CustomerDao;
import carsharing.model.Car;
import carsharing.model.Company;
import carsharing.model.Customer;

import java.util.Scanner;

public class BaseModelUI implements ModelUI {
    public static final Scanner scanner = new Scanner(System.in);
    public boolean isExit = false;
    static Car carSelected = null;
    static Company companySelected = null;
    static Customer customerSelected = null;
    static boolean isCustomer;
    static boolean haveCustomers = false;
    static boolean haveCompanies = false;
    static boolean haveCars = false;

    static H2CustomerDao h2CustomerDao;
    static H2CarDao h2CarDao;
    static H2CompanyDao h2CompanyDao;

    @Override
    public void modelMenuShow(String nameModel) {
        System.out.println("\n1. " + nameModel + " list");
        System.out.println("2. Create a " + nameModel.toLowerCase());
        System.out.println("3. Clear table " + nameModel.toLowerCase());
        System.out.println("0. Back");
    }

    @Override
    public void modelMenuProcess() {

    }

    @Override
    public void addModel() {

    }

    @Override
    public void modelsListMenuShow() {

    }

    @Override
    public void modelsListMenuProcess() {

    }

}
