package carsharing.dao;

import carsharing.model.BaseModel;
import carsharing.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class H2CustomerDao extends H2ModelDao {
    public H2CustomerDao() {
        CREATE = "CREATE TABLE IF NOT EXISTS customer (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR UNIQUE NOT NULL," +
                "rented_car_id INT," +
                "CONSTRAINT fk_rented_car_id FOREIGN KEY (rented_car_id)" +
                "REFERENCES car(id)" +
                ")";
    }

    public String getRentedCompany(Long id) {
        try (PreparedStatement ps = H2DaoUtils.getConnection().prepareStatement(RENTEDQUERY)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString(2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getRentedCar(Long id) {
        try (PreparedStatement ps = H2DaoUtils.getConnection().prepareStatement(RENTEDQUERY)) {
//            ps.setString(1, "car.name, company.name");
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
//            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs");
//            System.out.println(resultSet.getMetaData().getColumnCount());
//            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs");
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insertToTable(BaseModel model) {
        if (selectAll().isEmpty()) {
            resetAuto_Increment("customer");
        }
        INSERT = "INSERT INTO customer (name) VALUES (?)";
        Customer customer = (Customer) model;
        Long id = -1L;
        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(INSERT, new String[]{"id"})) {
            pst.setString(1, customer.getName());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id = gk.getLong("id");
            }
            gk.close();
        } catch (Exception e) {
            System.out.println("You cannot add a customer with this name: " + customer.getName());
        }
        return id;
    }

    @Override
    public List selectAll() {
        SELECT_ALL = "SELECT * FROM customer";
        return super.selectAll();
    }

    @Override
    public Customer fillModel(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getLong("id"));
        customer.setName(rs.getString("name"));
        return customer;
    }

    @Override
    public Customer findInTable(Long id) {
        SELECT_ONE = "SELECT * FROM customer WHERE id=?";
        return (Customer) super.findInTable(id);
    }

    @Override
    public void updateModel(BaseModel model) {
        UPDATE = "UPDATE customer SET rented_car_id=? WHERE id=?";
        Customer customer = (Customer) model;
        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(UPDATE);
        ) {
            Long carId = customer.getRented_car_id();
            pst.setObject(1, carId, Types.INTEGER);
            pst.setLong(2, customer.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
