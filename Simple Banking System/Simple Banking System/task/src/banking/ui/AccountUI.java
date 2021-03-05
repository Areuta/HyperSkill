package banking.ui;

import banking.model.Account;
import banking.model.AccountUtils;

import java.util.InputMismatchException;
import java.util.Objects;

public class AccountUI extends BaseUI {
    public AccountUI() {
        isExit = false;
        while (!isExit) {
            accountMenuShow();
            try {
                accountMenuProcess();
            } catch (InputMismatchException e) {
                System.out.println(badInput);
                scanner.nextLine();
            }

        }

    }

    private void accountMenuShow() {
        System.out.println("\n1. Balance\n" +
                "2. Add income\n" +
                "3. Do transfer\n" +
                "4. Close account\n" +
                "5. Log out\n" +
                "0. Exit");

    }

    private void accountMenuProcess() {
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1: {
                System.out.println("\nBalance: " + Objects.requireNonNull(accountSelected).getBalance());
                break;
            }
            case 2: {
                addIncome();
                break;
            }
            case 3: {
                doTransfer();
                break;
            }
            case 4: {
                deleteAccount();
                break;
            }

            case 5: {
                System.out.println("\nYou have successfully logged out!");
                isExit = true;
                break;
            }
            case 0: {
                System.out.println("\nBye!");
                isExit = true;
                isFinalExit = true;
                break;
            }
            default: {
                System.out.println(badInput);
            }
        }
    }

    private void deleteAccount() {
        accountDao.deleteAccount(accountSelected.getId());
        System.out.println("\nThe account has been closed!");
        isExit = true;
    }

    private void doTransfer() {
        System.out.println("\nTransfer\n" +
                "Enter card number:");
        String strCardNumber = scanner.next();

        if (strCardNumber.equals(accountSelected.getCardNumber())) {
            System.out.println("You can't transfer money to the same account!");
            return;
        }

        if (!AccountUtils.checkValidCard(strCardNumber)) {
            System.out.println("Probably you made a mistake in the card number. Please try again!");
            return;
        }

        Account account = accountDao.findInTable(strCardNumber);

        if (account == null) {
            System.out.println("Such a card does not exist.");
            return;
        }

        System.out.println("Enter how much money you want to transfer:");

        long transfer = scanner.nextLong();

        if (accountSelected.getBalance() < transfer) {
            System.out.println("Not enough money!");
            return;
        }

        accountDao.updateTranfer(accountSelected, account, transfer);
        System.out.println("Success!");

    }

    private void addIncome() {
        System.out.println("\nEnter income:");
        long income = scanner.nextLong();
        accountSelected.setBalance(accountSelected.getBalance() + income);
        accountDao.updateAccount(accountSelected);
        System.out.println("Income was added!");
    }

}
