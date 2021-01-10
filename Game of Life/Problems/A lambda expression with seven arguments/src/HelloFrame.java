import javax.swing.*;
import java.awt.*;

public class HelloFrame extends JFrame {
    public HelloFrame() throws HeadlessException {
        super("Hello App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new HelloFrame();
    }
}
