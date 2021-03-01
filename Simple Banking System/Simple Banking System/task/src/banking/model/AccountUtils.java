package banking.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountUtils {
    private static final String BIN = "400000";

    // Генерирует цифру 0-9
    public static String digitGenerator() {
        return String.valueOf((int) (Math.random() * 10));
    }

    // Генерирует новый номер карты
    public static String cardGenerator() {
        String s = IntStream.range(0, 9)
                .mapToObj(i -> digitGenerator())
                .collect(Collectors
                        .joining("", BIN, ""));
        String checksum = String.valueOf(generateChecksum(s));
        return s.concat(checksum);
    }

    public static int generateChecksum(String s) {
        int sum = 0;
        for (int i = 0; i < 15; i++) {
            int k;
            int c = Integer.valueOf(s.substring(i, i + 1));
            if (i % 2 == 0) {
                k = (c * 2 >= 10) ? (c * 2 - 9) : (c * 2);
            } else {
                k = c;
            }
            sum +=k;
        }
        return sum % 10 == 0 ? 0 : 10 - sum % 10;
    }

    // Генерирует новый пин карты
    public static String pinGenerator() {
        return IntStream.range(0, 4)
                .mapToObj(i -> digitGenerator())
                .collect(Collectors.joining(""));
    }

    public static boolean checkValidCard(String cN) {
        return cN.length() == 15 &&
                cN.startsWith(BIN) &&
                cN.matches("\\d") &&
                generateChecksum(cN.substring(0, 15)) == Integer.valueOf(cN.substring(15));
    }

    static boolean checkValidPin(String strPIN) {
        return strPIN.length() == 4 &&
                strPIN.matches("\\d");
    }
}
