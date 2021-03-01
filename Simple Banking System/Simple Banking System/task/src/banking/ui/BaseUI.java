package banking.ui;

import banking.dao.ArrayAccountDao;
import banking.model.Account;

import java.util.Scanner;

public abstract class BaseUI {
    static final Scanner scanner = new Scanner(System.in);
    boolean isExit = false; // используется для выхода и меню в каждом подклассе
    static boolean isFinalExit = false; // используется для выхода из программы
    static ArrayAccountDao accountDao;
    static final String badInput = "Bad Input!";
    static Account accountSelected;

}
