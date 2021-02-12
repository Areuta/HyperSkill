package encryptdecrypt;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Cipher {
    /*
    If there is no -mode, the program should work in enc mode.
    If there is no -alg you should default it to shift
    If there is no -key, the program should consider that key = 0.
    If there is no -data, and there is no -in the program should assume that the data is an empty string.
    If there is no -out argument, the program must print data to the standard output.
    If there are both -data and -in arguments, your program should prefer -data over -in.
*/

    public static void main(String[] args) {
        try {

            CipherMachine machine = new CipherMachine();
            StrategyFactory factory = new StrategyFactory();

            CipherParams cipherParams = new CipherParams(paramsFromArgs(args));

            Crypter crypter = factory.getInstance(cipherParams);

            machine.setCrypter(crypter);
            cipherParams.setCryptedText(machine.crypt(cipherParams));
            cipherParams.printCryptedText();

        } catch (NumberFormatException e) {
            System.out.println("Error: key must be an integer");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Invalid operation: [select: enc or dec]");
        } catch (IOException e) {
            System.out.println("Error: File not found");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: argument value not found");
        }

    }

    private static Map<String, String> paramsFromArgs(String[] args) {
        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < args.length - 1; i += 2) {
            params.put(args[i], args[i + 1]);
        }
        return params;
    }


}
