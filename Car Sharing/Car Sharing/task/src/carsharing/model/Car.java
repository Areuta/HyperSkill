package carsharing.model;

public class Car extends BaseModel {
    private Long company_id;

    public Car() {
    }

    public Car(String name, Long company_id) {
        this.name = name;
        this.company_id = company_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

}
