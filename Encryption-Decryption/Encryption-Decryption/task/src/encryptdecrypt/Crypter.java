package encryptdecrypt;

/**
 * Created by IntelliJ IDEA.
 * User: Anton
 * Date: 22.01.2021
 * Time: 12:46
 * To change this template use File | Settings | File and Code Templates.
 */
public abstract class Crypter implements Cryptable {
    String text;
    String cryptText;
    int key;
    CipherParams params;

    public Crypter(CipherParams params) {
        this.text = params.getText();
        this.key = params.getKey();
        this.params = params;
    }


}
