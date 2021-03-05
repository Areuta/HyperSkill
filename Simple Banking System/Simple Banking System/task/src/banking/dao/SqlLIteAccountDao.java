package banking.dao;

import banking.model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static banking.dao.DaoUtils.*;

public class SqlLIteAccountDao extends ModelDao {
    private static final String CREATE = "CREATE TABLE IF NOT EXISTS card (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "number TEXT UNIQUE," +
            "pin TEXT," +
            "balance INTEGER DEFAULT 0);";
    private static final String INSERT = "INSERT INTO card (number, pin, balance) VALUES (?, ?, ?)";
    private static final String SELECT_WHERE = "SELECT * FROM card WHERE card.number = ?";
    private static final String SELECT_ALL = "SELECT * FROM card";
    private static final String UPDATE = "UPDATE card SET balance = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM card WHERE id = ?";

    @Override
    public void updateTranfer(Account accountSelected, Account account, long transfer) {
        accountSelected.setBalance(accountSelected.getBalance() - transfer);
        account.setBalance(account.getBalance() + transfer);

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            updateAccount(accountSelected);
            updateAccount(account);
            connection.commit();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try (PreparedStatement ps = getConnection().prepareStatement(UPDATE)) {
            ps.setLong(1, account.getBalance());
            ps.setLong(2, account.getId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Long id) {
        try (PreparedStatement ps = getConnection().prepareStatement(DELETE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        executeUpdate(CREATE);
    }

    @Override
    public Long insertToTable(Account account) {
        Long id = -1L;
        try (PreparedStatement ps = getConnection().prepareStatement(INSERT, new String[]{"id"})) {
            ps.setString(1, account.getCardNumber());
            ps.setString(2, account.getPin());
            ps.setLong(3, account.getBalance());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getLong(1);
            }
            generatedKeys.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return id;
    }

    @Override
    public Account findInTable(String cardNumber) {
        Account account = null;
        try (PreparedStatement pst = getConnection().prepareStatement(SELECT_WHERE)) {
            pst.setString(1, cardNumber);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                account = fillAccount(resultSet);
            }
        } catch (SQLException throwables) {
            System.out.println("something wrong!");
        }
        return account;
    }

    @Override
    public List<Account> selectAll() {
        List<Account> list = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet rs = statement.executeQuery(SELECT_ALL)) {
            while (rs.next()) {
                list.add(fillAccount(rs));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Account fillAccount(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setCardNumber(rs.getString("number"));
        account.setPin(rs.getString("pin"));
        account.setBalance(rs.getInt("balance"));
        return account;
    }
}
