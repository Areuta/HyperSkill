package carsharing.dao;

public class H2CustomerDao extends H2ModelDao{
    public H2CustomerDao() {
CREATE = "CREATE TABLE IF NOT EXISTS customer (" +
        "id INT AUTO_INCREMENT PRIMARY KEY," +
        "name VARCHAR UNIQUE NOT NULL," +
        "rented_car_id INT," +
        "CONSTRAINT fk_rented_car_id FOREIGN KEY (rented_car_id)" +
        "REFERENCES car(id)" +
        ")";
    }


}
