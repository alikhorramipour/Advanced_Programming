import javax.swing.*;
import java.awt.*;

/**
 * this is the gui class for the calculator
 * @author Ali Khorramipour
 */

public class CalculatorGUI {
    JFrame calcFrame;

    public CalculatorGUI() {
        this.calcFrame = new JFrame();

        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(300, 300);
        calcFrame.setLocation(100, 200);
        calcFrame.setLayout(null);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(false);


        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(10, 150);
        keyboardPanel.setLayout(new GridLayout(4,3));
        calcFrame.add(keyboardPanel);

        for (int i=9; i > 0; i--){
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        keyboardPanel.add(sumBtn);
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);
        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);

        JTextArea display = new JTextArea(3,10);
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setLocation(50,20);
        calcFrame.getContentPane().add(scrollPane);

        calcFrame.setVisible(true);

        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(false);
    }
}
