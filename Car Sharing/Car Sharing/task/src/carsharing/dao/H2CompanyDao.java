package carsharing.dao;

import carsharing.model.BaseModel;
import carsharing.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class H2CompanyDao implements CompanyDao {
    private static final String CREATE
            = "CREATE TABLE IF NOT EXISTS company (" +
            "id INT AUTO_INCREMENT PRIMARY KEY," +
            "name VARCHAR UNIQUE NOT NULL);";
    private static final String SELECT
            = "SELECT id, name FROM company ORDER BY id";
    private static final String SELECT_ONE
            = "SELECT id, name FROM company WHERE id=?";
    private static final String INSERT
            = "INSERT INTO company (name) VALUES (?)";
    private static final String UPDATE
            = "UPDATE company SET name=? WHERE id=?";
    private static final String DELETE
            = "DELETE FROM company WHERE id=?";


    @Override
    public void createTable() {
        try (Connection connection = H2DaoFactory.createConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Long insertCompany(BaseModel model) {
        Company company = (Company) model;
        Long id = -1L;
        try (Connection connection = H2DaoFactory.createConnection();
             PreparedStatement pst = connection.prepareStatement(INSERT, new String[]{"id"})) {
            pst.setString(1, company.getName());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id = gk.getLong("id");
            }
            gk.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public boolean deleteCompany(BaseModel model) {
        return false;
    }

    @Override
    public Company findCompany(BaseModel model) {
        return null;
    }

    @Override
    public boolean updateCompany(BaseModel model) {
        return false;
    }

    @Override
    public Collection selectCompanysTO() {
        Collection<Company> company = new ArrayList<>();

        try (Connection connection = H2DaoFactory.createConnection();
             PreparedStatement pst = connection.prepareStatement(SELECT);
             ResultSet resultSet = pst.executeQuery()) {
            while (resultSet.next()) {
                company.add(fillContact(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return company;
    }

    private Company fillContact(ResultSet rs) throws SQLException {
        Company company = new Company();
        company.setId(rs.getLong("id"));
        company.setName(rs.getString("name"));
        return company;
    }
}
