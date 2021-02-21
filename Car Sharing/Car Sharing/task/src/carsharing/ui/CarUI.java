package carsharing.ui;

import carsharing.dao.H2CarDao;
import carsharing.dao.H2DaoUtils;
import carsharing.model.Car;
import carsharing.model.Company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarUI extends BaseModelUI {
    private H2CarDao h2CarDao;

    public CarUI(Company company) {
        h2CarDao = H2DaoUtils.getCarDao();
        setSelected(company);
        while (!isExit) {
            modelMenuShow("Car");
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
                System.out.println("Unexpected value: " + i);
        }
    }

    @Override
    public void addModel() {
        System.out.println("\nEnter the car name:");
        scanner.nextLine();
        Car car = new Car(scanner.nextLine(), getSelected().getId());
        if (h2CarDao.insertToTable(car) != -1) {
            System.out.println("The car was added!");
        }
    }

    @Override
    public void modelsListMenuShow() {
        System.out.println();
        List<Car> list = h2CarDao.selectCarsOfCompany((Company) getSelected());
        if (list.isEmpty()) {
            System.out.println("The car list is empty!");
        } else {
            System.out.println("Car list:");
            Collections.sort(list, Comparator.comparingLong(Car::getId));
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i).getName());
            }

        }
    }
}
