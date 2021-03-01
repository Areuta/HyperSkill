package banking.dao;

import banking.model.Account;

import java.sql.ResultSet;
import java.util.List;

public interface AccountDaoInt {
    void createTable(); // создание таблицы

    Long insertToTable( Account account);// вставка в таблицу новой строки

    void clearTable(String nameTable); // очистить таблицу

     Account findInTable(Long id); // найти в таблице строку по id

     Account findInTable(String cardNumber); // найти в таблице строку по cardNumber

    void updateaccount( Account account); // найти строку по id и заполнить значениями взятыми из модели

    List< Account> selectAll();  // получить все строки из таблицы

    List< Account> selectWhere(String where); // получить все строки удовлетворяющие условию в строке where

     Account fillaccount(ResultSet rs); // заполнить модель данными полученными из resultset



}

