package encryptdecrypt;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 23.01.2021
 * Time: 14:26
 */
public class UnicodeCrypter extends Crypter {
    public UnicodeCrypter(CipherParams params) {
        super(params);
    }

    @Override
    public String encrypt() {
        char[] chars = text.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(encryptCharUnicode(aChar, key));
        }

        return stringBuilder.toString();
    }

    @Override
    public String decrypt() {
        char[] chars = text.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(encryptCharUnicode(aChar, -key));
        }

        return stringBuilder.toString();
    }

    private static char encryptCharUnicode(char aChar, int k) {
        int inc = k >= 0 ? k%95 : 95 + k%95;
        return (char) (32 + (aChar + inc - 32) % 95);
    }
}
