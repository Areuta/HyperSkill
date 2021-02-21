package carsharing.model;

public class Company extends BaseModel {
    public Company(String name) {
        this.name = name;
    }

    public Company() {
    }

    @Override
    public String toString() {
        return getId() + ". " + getName();
    }

}
