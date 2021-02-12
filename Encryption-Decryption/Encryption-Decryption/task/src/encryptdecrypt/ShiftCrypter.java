package encryptdecrypt;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 23.01.2021
 * Time: 8:45
 */
public class ShiftCrypter extends Crypter {
    public ShiftCrypter(CipherParams params) {
        super(params);
    }

    @Override
    public String encrypt() {
        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(cryptCharShift(aChar, key));
        }
        return stringBuilder.toString();
    }

    @Override
    public String decrypt() {
        char[] chars = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(cryptCharShift(aChar, -key));
        }
        return stringBuilder.toString();
    }

    private static char cryptCharShift(char aChar, int k) {
        int inc = k >= 0 ? k%26 : 26 + k%26;
        if (aChar >= 97 && aChar <= 122) {
            return (char) (97 + Math.abs(aChar + inc - 97) % 26);
        }
        if (aChar >= 65 && aChar <= 90) {
            return (char) (65 + Math.abs(aChar + inc - 65) % 26);
        }
        return aChar;
    }

}
