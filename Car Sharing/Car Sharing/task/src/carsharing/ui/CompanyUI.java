package carsharing.ui;

import carsharing.dao.H2CompanyDao;
import carsharing.dao.H2DaoUtils;
import carsharing.model.Company;

import java.util.List;


public class CompanyUI extends BaseModelUI {
    private H2CompanyDao h2CompanyDao;

    private static boolean haveCompanies;
    public CompanyUI() {
        h2CompanyDao = H2DaoUtils.getCompanyDao();
        while (!isExit) {
            modelMenuShow("Company");
            modelMenuProcess();
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
                    modelsListMenuProcess();
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
                System.out.println("Unexpected value: " + i);
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

    @Override
    public void modelsListMenuShow() {
        System.out.println();
        List<Company> list = h2CompanyDao.selectAll();
        haveCompanies = !list.isEmpty();
        if (!haveCompanies) {
            System.out.println("The company list is empty!");
        } else {
            System.out.println("Choose a company:");
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
        Company company = h2CompanyDao.findInTable(l);
        if (company != null) {
            System.out.println("\n'" + company.getName() + "' company");
            new CarUI(company);
        } else {
            System.out.println("There is no such company!");
        }
    }
}
