package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Cipher {
    /*
    If there is no -mode, the program should work in enc mode.
    If there is no -key, the program should consider that key = 0.
    If there is no -data, and there is no -in the program should assume that the data is an empty string.
    If there is no -out argument, the program must print data to the standard output.
    If there are both -data and -in arguments, your program should prefer -data over -in.
*/
    private int key;
    private boolean crypt;
    private String text;
    private String in;
    private String out;
    private Map<String, String> params;
    private String alg;

    public Cipher() {
        this.key = 0;
        this.crypt = true;
        this.text = "";
        this.in = null;
        this.out = null;
        this.params = new HashMap<>();
        this.alg = "shift";
    }

    public static void main(String[] args) {
        Cipher cipher = new Cipher();
        cipher.readParams(args);
        cipher.text = cipher.getText();
        cipher.text = encryptDecryptText(cipher.text, cipher.key);
        cipher.printText();
    }

    public String getText() {
        if (this.in != null) {
            File fileIn = new File(this.in);
            if (fileIn.exists()) {
                try {
                    this.text = readFileAsString(this.in);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this.text;
    }

    private void printText() {
        if (this.out != null) {
            try (PrintWriter printWriter = new PrintWriter(this.out)) {
                printWriter.print(this.text);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(this.text);
        }
    }

    private void readParams(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            params.put(args[i], args[i + 1]);
        }

        for (Map.Entry<String, String> pair : params.entrySet()) {
            switch (pair.getKey()) {
                case "-mode": {
                    crypt = pair.getValue().equals("enc");
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
                case "-in": {
                    in = pair.getValue();
                    break;
                }
                case "-out": {
                    out = pair.getValue();
                    break;
                }
            }
        }

        if (!crypt) {
            this.key = -key;
        }
    }


    private static String encryptDecryptText(String wd, int k) {
        char[] chars = wd.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(encryptChar(aChar, k));
        }

        return stringBuilder.toString();
    }

    private static char encryptChar(char aChar, int k) {
        return (char) (32 + Math.abs((aChar + k - 32)) % 95);
    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
