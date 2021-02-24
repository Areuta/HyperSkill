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
    boolean isExit = false; // используется для выхода и меню в каждом подклассе
    static Car carSelected = null; // запоминает выбранную машину
    static Company companySelected = null; // запоминает выбраную компанию
    static Customer customerSelected = null; // запоминает выбранного пользователя
    static boolean isCustomer; // запоминает, что пользователь - клиент
    static boolean haveCustomers = false; // запоминает наличие клиентов
    static boolean haveCompanies = false; // запоминает наличие компаний
    static boolean haveCars = false; // запоминает есть ли у этой компании машины
    static final String badInput = "Unexpected value: ";

    static H2CustomerDao h2CustomerDao; // методы для работы с базой клиентов
    static H2CarDao h2CarDao; // методы для работы с базой машин
    static H2CompanyDao h2CompanyDao; // методы для работы с базой компаний

    @Override  // показывает основное меню каждой модели
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
