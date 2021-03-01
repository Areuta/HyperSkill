package banking.model;

import banking.dao.AccountDaoInt;

public class Account {
    private String cardNumber;
    private String pin;
    private long balance;
    private AccountDaoInt accountDao;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public AccountDaoInt getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDaoInt accountDao) {
        this.accountDao = accountDao;
    }

    public Account(AccountDaoInt accountDao, String cardNumber) {
        this.accountDao = accountDao;

        this.cardNumber = cardNumber;

        this.pin = AccountUtils.pinGenerator();

        this.balance = 0;
    }

    public Account(AccountDaoInt accountDao, String cardNumber, String pin, long balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.accountDao = accountDao;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
