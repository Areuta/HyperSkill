package banking.dao;

import banking.model.Account;

public class ArrayAccountDao extends ModelDao {
    private static String[][] accs;

    public ArrayAccountDao() {
        createTable();
    }

    @Override
    public void createTable() {
        accs = new String[3][1000];
        for (int i = 0; i < accs.length; i++) {
            accs[0][i] = "";
            accs[1][i] = "";
            accs[2][i] = "0";
        }
    }

    @Override
    public Long insertToTable(Account account) {
        Long i = -1L;
        int j = findFreeIndex();
        accs[0][j] = account.getCardNumber();
        accs[1][j] = account.getPin();
        accs[2][j] = String.valueOf(account.getBalance());

        return super.insertToTable(account);
    }

    private int findFreeIndex() {
        for (int i = 0; i < accs.length; i++) {
            if (accs[0][i].equals("")) {
                return i;
            }
        }

        return 0;
    }


    @Override
    public Account findInTable(String cardNumber) {
        for (int i = 0; i < accs.length; i++) {
            if (cardNumber.equals(accs[0][i])) {
                return new Account(this, cardNumber, accs[1][i], Long.parseLong(accs[2][i]));
            }
        }
        return null;
    }
}
