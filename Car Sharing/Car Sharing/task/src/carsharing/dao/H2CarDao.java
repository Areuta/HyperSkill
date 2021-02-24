package carsharing.dao;

import carsharing.model.BaseModel;
import carsharing.model.Car;
import carsharing.model.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class H2CarDao extends H2ModelDao {

    public H2CarDao() {
        CREATE = "CREATE TABLE IF NOT EXISTS car (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR UNIQUE NOT NULL," +
                "company_id INT NOT NULL," +
                "CONSTRAINT fk_company_id FOREIGN KEY (company_id) " +
                "REFERENCES company(id));";

        SELECT_ONE = "SELECT * FROM car WHERE id=?";
        SELECT_ALL = "SELECT * FROM car;";
    }

    @Override
    public void updateModel(BaseModel model) {
        UPDATE = "UPDATE car SET name=?, company_id=? WHERE id=?";
        Car car = (Car) model;
        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(UPDATE)
        ) {
            pst.setString(1, car.getName());
            pst.setLong(2, car.getCompany_id());
            pst.setLong(3, car.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long insertToTable(BaseModel model) {
        resetAuto_Increment("car");
        INSERT = "INSERT INTO car (name, company_id) VALUES (?, ?)";
        Car car = (Car) model;
        long id = -1L;

        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(INSERT, new String[]{"id"})) {
            pst.setString(1, car.getName());
            pst.setLong(2, car.getCompany_id());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id = gk.getLong("id");
            }
            gk.close();
        } catch (Exception e) {
            System.out.println("You cannot add such car!");

        }
        return id;
    }

    // метод создаёт список из всех машин данной компании company
    public List<Car> selectCarsOfCompany(Company company) {
        SELECT_WHERE = "SELECT * FROM car WHERE company_id=" + company.getId();
        return (selectWhere(SELECT_WHERE).stream().map(model -> (Car) model).collect(Collectors.toList()));
    }

    @Override
    public Car findInTable(Long id) {
        SELECT_ONE = "SELECT * FROM company WHERE id=?";
        return (Car) super.findInTable(id);
    }

    @Override
    public Car fillModel(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setId(rs.getLong("id"));
        car.setName(rs.getString("name"));
        car.setCompany_id(rs.getLong("company_id"));
        return car;
    }
}
