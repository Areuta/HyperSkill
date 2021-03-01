package banking.ui;

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
                "2. Log out\n" +
                "0. Exit");
    }

    private void accountMenuProcess() {
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1: {
                System.out.println("Balance: " + Objects.requireNonNull(accountSelected).getBalance());
                break;
            }
            case 2: {
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

}
