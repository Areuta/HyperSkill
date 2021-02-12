package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 22.01.2021
 * Time: 12:24
 * To change this template use File | Settings | File and Code Templates.
 */
public class StrategyFactory {

    public Crypter getInstance (CipherParams params) {
        if (params.getAlg().equals("shift")) {
            return new ShiftCrypter(params);
        }
        if (params.getAlg().equals("unicode")) {
            return new UnicodeCrypter(params);
        }

        return null;
    }

}
