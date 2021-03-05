package banking.ui;

import banking.model.Account;
import banking.model.AccountUtils;

import java.util.InputMismatchException;

import static banking.dao.DaoUtils.closeConnection;
import static banking.dao.DaoUtils.setAccountDao;

public class LoginUI extends BaseUI {

    public LoginUI(String storage) {
        accountDao = setAccountDao(storage);
        accountDao.createTable();
        isFinalExit = false;
        while (!isFinalExit) {
            logMenuShow();
            try {
                logMenuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
                scanner.nextLine();
            }
        }
        closeConnection();
    }

    // показывает основное меню программы
    void logMenuShow() {
        System.out.println("\n1. Create an account\n" +
                "2. Log into account\n" +
                "3. Accounts list\n" +
                "0. Exit");
    }

    // обрабатывает выбор пользователя в основном меню
    void logMenuProcess() {

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1: {
                newCardCreate();
                break;
            }
            case 2: {
                logAccount();
                break;
            }
            case 3: {
                accountDao.selectAll().forEach(System.out::println);
                break;
            }
            case 0: {
                System.out.println("\nBye!");
                isFinalExit = true;
                scanner.close();
                break;
            }
            default: {
                System.out.println(badInput);
            }
        }
    }

    // создаёт новую карту рандомным образом
    private void newCardCreate() {
        String newCard;
        do {
            newCard = AccountUtils.cardGenerator();
        }
        while (accountDao.findInTable(newCard) != null);

        Account newAccount = new Account(newCard);
        accountDao.insertToTable(newAccount);
        System.out.println("\nYour card has been created\n"
                + "Your card number:\n"
                + newAccount.getCardNumber()
                + "\nYour card PIN:\n"
                + newAccount.getPin());
//        System.out.println(AccountUtils.checkValidCard(newCard));

    }

    /* обрабатывает введённые пользотелем данные карты
     и впускает в меню клиента*/
    private void logAccount() {
        System.out.println("\nEnter your card number:");
        String strCardNumber = scanner.next();
        System.out.println("Enter your PIN:");
        String strPIN = scanner.next();

        try {
            Account account = accountDao.findInTable(strCardNumber);
            if (strPIN.equals(account.getPin())) {
                accountSelected = account;
                System.out.println("You have successfully logged in!");
                new AccountUI();
            }
        } catch (Exception e) {
            System.out.println("Wrong card number or PIN!");
        }

    }

}
