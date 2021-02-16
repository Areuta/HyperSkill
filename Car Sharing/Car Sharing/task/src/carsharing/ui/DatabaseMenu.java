package carsharing.ui;

import carsharing.dao.H2CompanyDao;
import carsharing.model.Company;

import java.util.Collection;
import java.util.Scanner;

public class DatabaseMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private boolean isExit = false;
    private final H2CompanyDao h2CompanyDao = new H2CompanyDao();

    public boolean isExit() {
        return isExit;
    }

    public void logMenuShow() {
        h2CompanyDao.createTable();
        System.out.println("\n1. Log in as a manager");
        System.out.println("0. Exit");
        switch (scanner.nextInt()) {
            case 0: {
                isExit = true;
                break;
            }
            case 1: {
                companyMenuShow();
                break;
            }
        }
    }

    private void companyMenuShow() {
        System.out.println("\n1. Company list");
        System.out.println("2. Create a company");
        System.out.println("0. Back");
        switch (scanner.nextInt()) {
            case 0: {
                logMenuShow();
                break;
            }
            case 1: {
                companyListShow();
                break;
            }
            case 2: {
                createCompanyShow();
                break;
            }
        }
    }

    private void createCompanyShow() {
        System.out.println("\nEnter the company name:");
        scanner.nextLine();
        Company company = new Company(scanner.nextLine());
        h2CompanyDao.insertCompany(company);
        companyMenuShow();
    }

    private void companyListShow() {
        System.out.println();
        Collection<String> list = h2CompanyDao.selectCompanysTO();
        if (list.isEmpty()) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Company list:");
            list.stream().forEach(System.out::println);
        }
        companyMenuShow();
    }
}
