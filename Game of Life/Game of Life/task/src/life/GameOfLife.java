package life;

import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class GameOfLife extends JFrame {
    private static int seed = 102;
    private static int UPDATE_INTERVAL = 1000; // milliseconds
    private static int dimOfWorld = 20;
    private static int countGen = 0;
    private static JLabel label1;
    static final String label1Text = "Generation: ";
    private static JLabel label2;
    static final String label2Text = "Alive: ";
    private static JPanel labelsPanel;
    private static JPanel gridsPanel;
    private static JToggleButton playBtn;
    private static JButton resetBtn;
    private static JSlider speedSlider;
    private static JButton changeColor;
    private Generation currentGeneration;
    private static boolean doLife = false;
    static Color aliveColor = Color.black;

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
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        currentGeneration = new Generation(seed);
    }

    private void update() {
        // Create a new thread to run update at regular interval
        Thread updateThread = new Thread() {
            @Override
            public void run() {
                while (doLife) {
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
        speedSlider = new JSlider(0, 2000);
        speedSlider.setToolTipText("Speed");
        Dictionary<Integer, JLabel> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("Fast"));
        labelTable.put(2000, new JLabel("Slow"));
        speedSlider.setLabelTable((Dictionary) labelTable);
        speedSlider.setPaintLabels(true);

        playBtn = new JToggleButton("Play", false);
//        playBtn = new JToggleButton("▶/❚❚");
        playBtn.setName("PlayToggleButton");

        resetBtn = new JButton("Reset");
        resetBtn.setName("ResetButton");

        label1 = new JLabel();
        label1.setName("AliveLabel");
        label1.setText(label1Text);

        label2 = new JLabel();
        label2.setName("GenerationLabel");
        label2.setText(label2Text);

        JLabel labelSpeed = new JLabel("Speed");

        changeColor = new JButton("Change Color");

        labelsPanel = new JPanel();
        labelsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        addComponent(playBtn);
        addComponent(resetBtn);
        addComponent(changeColor);
        addComponent(label1);
        addComponent(label2);
        addComponent(labelSpeed);
        addComponent(speedSlider);

        add(labelsPanel);
        gridsPanel = new JPanel();
        gridsPanel.setLayout(new GridLayout(dimOfWorld, dimOfWorld, 1, 1));
        gridsPanel.setBackground(Color.lightGray);
        add(gridsPanel);

        Container container = getContentPane();
        container.setLayout(new BorderLayout(10, 0));
        container.add(labelsPanel, BorderLayout.WEST);
        container.add(gridsPanel, BorderLayout.CENTER);

        addActionListeners();
    }

    private void addComponent(JComponent component) {
        Font font = new Font("Courier", Font.PLAIN, 16);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        component.setFont(font);
        labelsPanel.add(component);
        labelsPanel.add(Box.createVerticalStrut(10));
    }

    private void addActionListeners() {
        playBtn.addActionListener(actionEvent -> {
                    if (playBtn.isSelected()) {
                        playBtn.setText("Stop");
                        doLife = true;
                        update();
                    } else {
                        playBtn.setText("Play");
                        doLife = false;
                    }
                }
        );
        resetBtn.addActionListener(actionEvent -> {
            countGen = 0;
            doLife = false;
            try {
                Thread.sleep(UPDATE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentGeneration = new Generation(++seed);
            playBtn.setSelected(true);
            playBtn.setText("Stop");
            doLife = true;
            update();

        });

        speedSlider.addChangeListener(changeEvent -> {
            UPDATE_INTERVAL = ((JSlider) changeEvent.getSource()).getValue();
        });

        changeColor.addActionListener(actionEvent -> {
            aliveColor = JColorChooser.showDialog(null, "ColorChooser", Color.BLACK);
        });

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
