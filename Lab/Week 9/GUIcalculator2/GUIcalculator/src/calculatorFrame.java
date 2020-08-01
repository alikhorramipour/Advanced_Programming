import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class calculatorFrame extends JFrame {

    private JButton[] btns;
    private JButton ACButton;
    private JTextField tfield;
    private JPanel jf1;
    private JPanel jf2;
    String operator;
    JMenuBar jmb = new JMenuBar();
    JMenu jm1 = new JMenu("Main Menu");


    public calculatorFrame () {
        super("Calculator");
        jf2 = new JPanel();
        jf2.setLayout(new BorderLayout(2,2));
        jf2.setVisible(true);
        jf1 = new JPanel();
        jf1.setLayout(new GridLayout (4,4,2,2));
        jf1.setVisible(true);
        setLocation(100,100);
        setSize(1024,768);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        tfield.setEditable(false);

        btns = new JButton[16];
        ACButton = new JButton("AC");
        ACButton.setToolTipText("AC!!!");
        tfield = new JTextField();
        tfield.setToolTipText("here is the screen!");
        for (int i = 0; i < 10; i++)
            btns[i] = new JButton(i + "");
        btns[10] = new JButton("+");
        btns[11] = new JButton("-");
        btns[12] = new JButton("*");
        btns[13] = new JButton("/");
        btns[14] = new JButton("=");
        btns[15] = new JButton(".");

        ButtonHandler handler = new ButtonHandler();
        for (int j = 0; j < 16; j++) {
            jf1.add(btns[j]);
            btns[j].addActionListener(handler);
        }
        ACButton.addActionListener(handler);
        tfield.addActionListener(handler);
        jf2.add(ACButton,BorderLayout.EAST);
        jf2.add(tfield,BorderLayout.CENTER);
        add(jf2,BorderLayout.CENTER);
        add(jf1  ,BorderLayout.PAGE_END );
       // add(jf1);
        Keyhandler k = new Keyhandler();
     //   jf2.addKeyListener(k);
        tfield.addKeyListener(k);

      //  tfield.setEditable(false);
        setVisible(true);
        JMenuItem jmi1 = new JMenuItem("Exit");
        JMenuItem jmi2 = new JMenuItem("Copy");
        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection ss = new StringSelection(tfield.getText());
                Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
                cb.setContents(ss,null);
            }
        });
        jmi1.setMnemonic('d');
        jmi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        jm1.add(jmi1);
        jm1.add(jmi2);
        jmb.add(jm1);
       // setJMenuBar(jmb);
        add(jmb,BorderLayout.NORTH);

    }

    public class Keyhandler extends KeyAdapter {

        double x = 0;
        double y = 1;
        double result;
    //    String operator;

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);

           if (e.getKeyChar() == '=')
               e.consume();  /*  tfield.setText(tfield.getText().replace('=',' '));  */

            switch (e.getKeyChar()) { /*
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                case '.':
                    tfield.setText(tfield.getText() + e.getKeyChar());
                    break;
               /* case :
                    tfield.setText("");
                    break; */
                case '+':
                case '-':
                case '*':
                case '/':
               //     tfield.setText(tfield.getText() + e.getKeyChar());
                    operator = Character.toString(e.getKeyChar());
                    break;
                case '=':
                    x = Double.parseDouble(tfield.getText().substring(0, tfield.getText().indexOf(operator)));
                    System.out.println(x);
                    y = Double.parseDouble(tfield.getText().substring(tfield.getText().indexOf(operator) + 1, tfield.getText().length()));
                    System.out.println(x + y);
                    switch (operator) {
                        case "+":
                            result = x + y;
                            tfield.setText(tfield.getText() + "=" + result);
                           // tfield.setText(tfield.getText().);

                            break;
                        case "-":
                            result = x - y;
                            tfield.setText(tfield.getText() + "=" + result);
                             break;
                        case "*":
                            result = x * y;
                            tfield.setText(tfield.getText() + "=" + result);
                            break;
                        case "/":
                            result = x / y;
                            tfield.setText(tfield.getText() + "=" + result);
                            break;


                    }



            }
        }
    }

    private class ButtonHandler implements ActionListener {

        double x = 0;
        double y = 1;
        double result;
     //   String operator;
        String firstOperand;
        String secondOperand;
        JOptionPane jop = new JOptionPane();

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "0":
                case ".":
                    tfield.setText(tfield.getText() + e.getActionCommand());
                    tfield.requestFocus();
                    break;
                case "AC":
                    tfield.setText("");
                    tfield.requestFocus();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    tfield.setText(tfield.getText() + e.getActionCommand());
                    operator = e.getActionCommand();
                    tfield.requestFocus();
                    break;
                case "=":

                    x = Double.parseDouble(tfield.getText().substring(0,tfield.getText().indexOf(operator)));
                    y = Double.parseDouble(tfield.getText().substring(tfield.getText().indexOf(operator)+1 ,tfield.getText().length()));
                    switch (operator) {
                        case "+":

                            result = x + y;
                            tfield.setText(tfield.getText()+ " = " + result);
                            tfield.requestFocus();
                            break;
                        case "-":

                            result = x - y;
                            tfield.setText(tfield.getText()+ " = " + result);
                            tfield.requestFocus();
                            break;
                        case "*":

                            result = x * y;
                            tfield.setText(tfield.getText()+ " = " + result);
                            tfield.requestFocus();
                            break;
                        case "/":

                            result = x / y;
                            tfield.setText(tfield.getText()+ " = " + result);
                            tfield.requestFocus();
                            break;
                    }




                    }
        }

    }


}
