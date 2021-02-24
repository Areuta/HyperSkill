package carsharing.ui;

import carsharing.dao.H2DaoUtils;
import carsharing.model.Car;
import carsharing.model.Company;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;

public class CarUI extends BaseModelUI {
    private List<Car> carList;

    public CarUI() {
        isExit = false;
        while (!isExit) {
            modelMenuShow("Car");
            try {
                modelMenuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
                scanner.nextLine();
            }
        }
    }

    public CarUI(Company company, boolean isCustomer) {
        h2CarDao = H2DaoUtils.getCarDao();
        companySelected = company;
        if (isCustomer) {
            modelsListMenuShow();
            if (haveCars) {
                try {
                    modelsListMenuProcess();
                } catch (InputMismatchException e) {
                    System.out.println(badInput);
                    scanner.nextLine();
                }
            }
        } else {
            new CarUI();
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
                if (isCustomer && haveCars) {
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
                h2CarDao.clearTable("car");
                break;
            }
            default:
                System.out.println(badInput + i);
        }
    }

    @Override
    public void modelsListMenuShow() {
        carList = h2CarDao.selectCarsOfCompany(companySelected);
        haveCars = !carList.isEmpty();
        if (!haveCars) {
            System.out.println("The car list is empty!");
        } else {
            if (!isCustomer) {
                System.out.println("\nCar list:");
            }
            carList.sort(Comparator.comparingLong(Car::getId));
            for (int i = 0; i < carList.size(); i++) {
                System.out.println((i + 1) + ". " + carList.get(i).getName());
            }
            if (isCustomer) {
                System.out.println("0. Back");
            }
        }
    }

    @Override
    public void modelsListMenuProcess() {
        int l = scanner.nextInt();
        if (l == 0) {
            return;
        }
        if (l > 0 && l <= carList.size()) {
            carSelected = carList.get(l - 1);
            customerSelected.setRented_car_id(carSelected.getId());
            h2CustomerDao.updateModel(customerSelected);
            System.out.println("You rented '" + carSelected.getName() + "'");
        } else {
            System.out.println("There is no such car!");
        }
    }

    @Override
    public void addModel() {
        System.out.println("\nEnter the car name:");
        scanner.nextLine();
        Car car = new Car(scanner.nextLine(), companySelected.getId());
        if (h2CarDao.insertToTable(car) != -1) {
            System.out.println("The car was added!");
        }
    }
}



