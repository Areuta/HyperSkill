package encryptdecrypt;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 22.01.2021
 * Time: 10:10
 * To change this template use File | Settings | File and Code Templates.
 */
public class CipherMachine {
    private Crypter crypter;

    public void setCrypter(Crypter crypter) {
        this.crypter = crypter;
    }

    public String crypt (CipherParams params) {
        if (params.getMode().equals("dec")) {
            return this.crypter.decrypt();
        } else {
            return this.crypter.encrypt();
        }
    }
}
