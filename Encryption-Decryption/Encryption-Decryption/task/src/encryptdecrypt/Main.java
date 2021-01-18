package encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int key = 0;
    private static boolean crypt = true;
    private static String text = "";
    private static Map<String, String> params = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            params.put(args[i], args[i + 1]);
        }

        for (Map.Entry<String, String> pair : params.entrySet()) {
            switch (pair.getKey()) {
                case "-mode": {
                    crypt = pair.getValue().equals("enc") ? true : false;
                    break;
                }
                case "-key": {
                    key = Integer.parseInt(pair.getValue());
                    break;
                }
                case "-data": {
                    text = pair.getValue();
                    break;
                }
            }
        }

        if (!crypt) {
            key = -key;
        }

        System.out.println(encryptText(text));

    }


    private static String encryptText(String wd) {
        char[] chars = wd.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(encryptChar(aChar));
        }

        return stringBuilder.toString();
    }

    private static char encryptChar(char aChar) {
        return (char) (32 + Math.abs((aChar + key - 32)) % 95);
    }
}
