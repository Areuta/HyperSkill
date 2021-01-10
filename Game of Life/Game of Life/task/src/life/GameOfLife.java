package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private static int seed = 102;
    private static int UPDATE_INTERVAL = 500; // milliseconds
    private static int dimOfWorld = 20;
    private static int countGen = 0;
    private static JLabel label1;
    static final String label1Text = "Generation: ";
    private static JLabel label2;
    static final String label2Text = "Alive: ";
    private static JPanel labelsPanel;
    private static JPanel gridsPanel;
    private Generation currentGeneration;
    private Generation initialGeneration;

    public static int getDimOfWorld() {
        return dimOfWorld;
    }

    public static int getCountGen() {
        return countGen;
    }

    public static JLabel getLabel1() {
        return label1;
    }

    public static JLabel getLabel2() {
        return label2;
    }

    public static JPanel getGridsPanel() {
        return gridsPanel;
    }

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentsInit();
        pack();
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        dimOfWorld = 20;
        initialGeneration = new Generation(seed);
        currentGeneration = initialGeneration;

        // Create a new thread to run update at regular interval
        Thread updateThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    currentGeneration = NextLives.nextLife(currentGeneration);
                    countGen++;
                    currentGeneration.paintGeneration();
                    repaint();  // Refresh the JFrame. Called back paintComponent()
                    try {
                        // Delay and give other thread a chance to run
                        Thread.sleep(UPDATE_INTERVAL);  // milliseconds
                    } catch (InterruptedException ignore) {
                    }
                }
            }
        };
        updateThread.start(); // called back run()

    }

    private void componentsInit() {
        Font font = new Font("Courier", Font.PLAIN, 12);
        label1 = new JLabel();
        label1.setName("AliveLabel");
        label1.setFont(font);
        label1.setFont(label1.getFont().deriveFont(16f));
        label1.setText(label1Text);

        label2 = new JLabel();
        label2.setName("GenerationLabel");
        label2.setFont(new Font("Courier", Font.PLAIN, 16));
        label2.setText(label2Text);

        labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        labelsPanel.add(label1);
        labelsPanel.add(label2);
        add(labelsPanel);

        gridsPanel = new JPanel();
        gridsPanel.setLayout(new GridLayout(dimOfWorld, dimOfWorld, 1, 1));
        gridsPanel.setBackground(Color.lightGray);
        add(gridsPanel);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(labelsPanel, BorderLayout.NORTH);
        container.add(gridsPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOfLife();
            }
        });

    }


}
