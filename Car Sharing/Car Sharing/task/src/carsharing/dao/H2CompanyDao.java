package carsharing.dao;

import carsharing.model.BaseModel;
import carsharing.model.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class H2CompanyDao extends H2ModelDao {

    public H2CompanyDao() {
        CREATE = "CREATE TABLE IF NOT EXISTS company (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR UNIQUE NOT NULL);";
        SELECT_ALL = "SELECT * FROM company";
    }

    @Override
    public void updateModel(BaseModel model) {
        UPDATE = "UPDATE company SET name=? WHERE id=?";
        Company company = (Company) model;
        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(UPDATE)
        ) {
            pst.setString(1, company.getName());
            pst.setLong(2, company.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long insertToTable(BaseModel model) {
        resetAuto_Increment("company");
        INSERT = "INSERT INTO company (name) VALUES (?)";
        Company company = (Company) model;
        long id = -1L;

        try (PreparedStatement pst = H2DaoUtils.getConnection().prepareStatement(INSERT, new String[]{"id"})) {
            pst.setString(1, company.getName());
            pst.executeUpdate();
            ResultSet gk = pst.getGeneratedKeys();
            if (gk.next()) {
                id = gk.getLong("id");
            }
            gk.close();
        } catch (Exception e) {
            System.out.println("You cannot add a company with this name: " + company.getName());
        }
        return id;
    }

    @Override
    public Company findInTable(Long id) {
        SELECT_ONE = "SELECT * FROM company WHERE id=?";
        return (Company) super.findInTable(id);
    }

    @Override
    public Company fillModel(ResultSet rs) throws SQLException {
        Company company = new Company();
        company.setId(rs.getLong("id"));
        company.setName(rs.getString("name"));
        return company;
    }
}
