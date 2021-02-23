package carsharing.ui;

import carsharing.dao.H2DaoUtils;
import carsharing.model.Customer;

import java.util.List;

public class CustomerUI extends BaseModelUI {

    public CustomerUI() {
        h2CustomerDao = H2DaoUtils.getH2CustomerDao();
        modelsListMenuShow();
        if (haveCustomers) {
            modelsListMenuProcess();
        }
    }

    @Override
    public void modelsListMenuShow() {
        System.out.println();
        List<Customer> list = h2CustomerDao.selectAll();
        haveCustomers = !list.isEmpty();
        if (!haveCustomers) {
            System.out.println("The customer list is empty!");
        } else {
            System.out.println("The customer list:");
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

        customerSelected = h2CustomerDao.findInTable(l);
        if (customerSelected != null) {
            isExit = false;
            while (!isExit) {
                rentMenuShow();
                rentMenuProcess();
            }
        } else {
            System.out.println("There is no such customer!");
        }
    }

    private void rentMenuShow() {
        System.out.println("\n1. Rent a car");
        System.out.println("2. Return a rented car");
        System.out.println("3. My rented car");
        System.out.println("0. Back");
    }

    private void rentMenuProcess() {
        String rentedCar = h2CustomerDao.getRentedCar(customerSelected.getId());
        String rentedCompany = h2CustomerDao.getRentedCompany(customerSelected.getId());
        int i = scanner.nextInt();
        switch (i) {
            case 0: {
                isExit = true;
                break;
            }
            case 1: {
                if (rentedCar == null) {
                    new CompanyUI(true);
                }else {
                    System.out.println("\nYou've already rented a car!");
                }
                break;
            }
            case 2: {
                if (rentedCar == null) {
                    System.out.println("You didn't rent a car!");
                }else {
                    customerSelected.setRented_car_id(null);
                    h2CustomerDao.updateModel(customerSelected);
                    System.out.println("\nYou've returned a rented car!");
                }
                break;
            }
            case 3: {
                if (rentedCar == null) {
                    System.out.println("You didn't rent a car!");
                }else {
                    System.out.println("\nYour rented car:");
                    System.out.println(rentedCar);
                    System.out.println("Company:");
                    System.out.println(rentedCompany);
                }
                break;
            }
            default:
                System.out.println("Unexpected value: " + i);
        }
    }

}
