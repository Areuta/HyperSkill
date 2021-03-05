package banking.dao;

import banking.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AccountDaoInt {
    void createTable(); // создание таблицы

    Long insertToTable(Account account);// вставка в таблицу новой строки

    void clearTable(String nameTable); // очистить таблицу

    void deleteAccount(Long id); // удаление карты

    Account findInTable(Long id); // найти в таблице строку по id

    Account findInTable(String cardNumber); // найти в таблице строку по cardNumber

    void updateAccount(Account account); // найти строку по id и заполнить значениями взятыми из модели

    List<Account> selectAll();  // получить все строки из таблицы

    List<Account> selectWhere(String where); // получить все строки удовлетворяющие условию в строке where

    Account fillAccount(ResultSet rs) throws SQLException; // заполнить модель данными полученными из resultset


    void updateTranfer(Account accountSelected, Account account, long transfer);
}

