package banking.dao;

import banking.model.Account;

import java.sql.ResultSet;
import java.util.List;

public class ModelDao implements AccountDaoInt {
    @Override
    public void createTable() {

    }

    @Override
    public Long insertToTable(Account account) {
        return null;
    }

    @Override
    public void clearTable(String nameTable) {

    }

    @Override
    public Account findInTable(Long id) {
        return null;
    }

    @Override
    public Account findInTable(String cardNumber) {
        return null;
    }

    @Override
    public void updateaccount(Account account) {

    }

    @Override
    public List<Account> selectAll() {
        return null;
    }

    @Override
    public List<Account> selectWhere(String where) {
        return null;
    }

    @Override
    public Account fillaccount(ResultSet rs) {
        return null;
    }
}
