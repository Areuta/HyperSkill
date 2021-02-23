package carsharing.model;

public class Customer extends BaseModel{
    private Long rented_car_id;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {

    }

    public Long getRented_car_id() {
        return rented_car_id;
    }

    public void setRented_car_id(Long rented_car_id) {
        this.rented_car_id = rented_car_id;
    }

}
