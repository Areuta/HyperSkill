package carsharing.ui;

import carsharing.model.BaseModel;

import java.util.Scanner;

public class BaseModelUI implements ModelUI {
    public static final Scanner scanner = new Scanner(System.in);
    public boolean isExit = false;
    private BaseModel selected = null;

    public BaseModel getSelected() {
        return selected;
    }

    public void setSelected(BaseModel selected) {
        this.selected = selected;
    }

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
