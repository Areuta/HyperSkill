package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 23.01.2021
 * Time: 9:24
 */
public class CipherParams {
    private String mode;
    private String text;
    private String alg;
    private int key;
    private String in;
    private String out;
    private String cryptedText;

    public void setCryptedText(String cryptedText) {
        this.cryptedText = cryptedText;
    }

    public CipherParams() {
        this.mode = "enc";
        this.alg = "shift";
        this.text = "";
        this.key = 0;
        this.in = null;
        this.out = null;
        this.cryptedText = "";
    }

    public String getMode() {
        return mode;
    }

    public String getAlg() {
        return alg;
    }

    public int getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public CipherParams(Map<String, String> params) throws IllegalArgumentException {
        this();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            switch (pair.getKey()) {
                case "-mode": {
                    this.mode = pair.getValue();
                    break;
                }
                case "-key": {
                    this.key = Integer.parseInt(pair.getValue());
                    break;
                }
                case "-alg": {
                    this.alg = pair.getValue();
                    break;
                }
                case "-data": {
                    this.text = pair.getValue();
                    break;
                }
                case "-in": {
                    this.in = pair.getValue();
                    break;
                }
                case "-out": {
                    this.out = pair.getValue();
                    break;
                }
            }
        }
        this.text = setText();
    }

    public void printCryptedText() throws FileNotFoundException {
        if (this.out != null) {
            PrintWriter printWriter = new PrintWriter(this.out);
            printWriter.print(this.cryptedText);
            printWriter.close();
        } else {
            System.out.println(this.cryptedText);
        }

    }

    public String setText() {
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

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
