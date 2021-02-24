package carsharing.ui;

import carsharing.dao.H2DaoUtils;
import carsharing.model.Company;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyUI extends BaseModelUI {
    public CompanyUI() {
        while (!isExit) {
            modelMenuShow("Company");
            try {
                modelMenuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
                scanner.nextLine();
            }
        }
    }

    public CompanyUI(boolean isCustomer) {
        h2CompanyDao = H2DaoUtils.getCompanyDao();
        if (isCustomer) {
            modelsListMenuShow();
            if (haveCompanies) {
                try {
                    modelsListMenuProcess();
                } catch (InputMismatchException e) {
                    System.out.println(badInput);
                    scanner.nextLine();
                }
            }
        }
        else {
            new CompanyUI();
        }
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
                modelsListMenuShow();
                if (haveCompanies) {
                    try {
                        modelsListMenuProcess();
                    } catch (InputMismatchException e) {
                        System.out.println(badInput);
                        scanner.nextLine();
                    }
                }
                break;
            }
            case 2: {
                addModel();
                break;
            }
            case 3: {
                h2CompanyDao.clearTable("car");
                h2CompanyDao.clearTable("company");
                break;
            }
            default:
                System.out.println(badInput + i);
        }
    }

    @Override
    public void modelsListMenuShow() {
        System.out.println();
        List<Company> list =
                h2CompanyDao.selectAll().stream().map(model -> (Company)model).collect(Collectors.toList());
        haveCompanies = !list.isEmpty();
        if (!haveCompanies) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Choose a company:");
            list.forEach(System.out::println);
            System.out.println("0. Back");
        }
    }

    @Override
    public void modelsListMenuProcess() {
        long l = scanner.nextLong();
        if (l == 0) {
            return;
        }

        Company company = h2CompanyDao.findInTable(l);
        if (company != null) {
            System.out.println(isCustomer ? "\nChoose a car:" : "\n'" + company.getName() + "' company");
            new CarUI(company, isCustomer);
        } else {
            System.out.println("There is no such company!");
        }
    }

    @Override
    public void addModel() {
        System.out.println("\nEnter the company name:");
        scanner.nextLine();
        Company company = new Company(scanner.nextLine());
        if (h2CompanyDao.insertToTable(company) != -1) {
            System.out.println("The company was created!");
        }
    }
}
