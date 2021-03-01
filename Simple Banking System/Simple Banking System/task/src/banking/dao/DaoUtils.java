package banking.dao;

import java.util.Objects;

public class DaoUtils {
    private static ArrayAccountDao accountDao;

    public static ArrayAccountDao getAccountDao(String array) {
        if (array.equals("Array")) {
            return Objects.requireNonNullElseGet(accountDao, ArrayAccountDao::new);
        }
        return Objects.requireNonNullElseGet(accountDao, ArrayAccountDao::new);
    }

    private boolean checkUniqueCardPin() {
        return false;
    }

}
