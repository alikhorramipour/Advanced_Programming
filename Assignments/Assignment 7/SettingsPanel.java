import sun.awt.windows.ThemeReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.J;
import static javafx.scene.input.KeyCode.L;

public class SettingsPanel extends JDialog implements Serializable {
    DirectoryChooser dc;
    private int numOfConcurrentDownloads = 1;
    private int LAFIndex = 0;
    String LAF = "javax.swing.plaf.metal.MetalLookAndFeel";
    ArrayList<String> filterSitesList = new ArrayList<>();
    private static final long serialVersionUID = 1113799434508676095L;
    private int lang = 1;

    public SettingsPanel (MainPage c) {
        retrieveSettings();
        Language programLang = new Language();
        if (this.getLang() == 0)
            programLang.mainLangToEng();
        else
            programLang.mainLangToFarsi();
        dc = new DirectoryChooser("Directory",programLang.lang.get(15));
        JPanel settings = new JPanel();
        settings.setLayout(null);
        setSize(new Dimension(850,500));
        setModal(true);
    /*    settings.setBorder(BorderFactory.createMatteBorder(5,0,5,0,new Color(255,63,92)));
        settings.setBorder(BorderFactory.createMatteBorder(0,5,0,5,new Color(255,120,92))); */
        JPanel topBorder = new JPanel();
        topBorder.setBackground(new Color(62,173,88));
        topBorder.setBounds(0,0,900,8);
        settings.add(topBorder);
        JPanel topBorder2 = new JPanel();
        topBorder2.setBackground(new Color(255,255,255));
        topBorder2.setBounds(0,8,900,8);
        settings.add(topBorder2);
        JPanel topBorder3 = new JPanel();
        topBorder3.setBackground(new Color(62,173,88));
        topBorder3.setBounds(0,16,900,8);
        settings.add(topBorder3);
        JPanel bottomBorder = new JPanel();
        bottomBorder.setBackground(new Color(62,173,88));
        bottomBorder.setBounds(0,453,900,8);
        settings.add(bottomBorder);
        JPanel bottomBorder2 = new JPanel();
        bottomBorder2.setBackground(new Color(255,255,255));
        bottomBorder2.setBounds(0,445,900,8);
        settings.add(bottomBorder2);
        JPanel bottomBorder3 = new JPanel();
        bottomBorder3.setBackground(new Color(62,173,88));
        bottomBorder3.setBounds(0,437,900,8);
        settings.add(bottomBorder3);


        JLabel jl1 = new JLabel(programLang.lang.get(13));
        JTextField jtf = new JTextField(10   );
        jtf.setText("" + numOfConcurrentDownloads);
        jl1.setBounds(70,80,300,30);
        settings.add(jl1);
        jtf.setBounds(300,80,100,30);
        jtf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                numOfConcurrentDownloads = Integer.parseInt(jtf.getText());
            }
        });
        settings.add(jtf);
        JLabel jl12 = new JLabel(programLang.lang.get(14));
        jl12.setBounds(75,140,300,30);
        settings.add(jl12);
        dc.setBounds(120,140,300,100);
        add(dc);
        UIManager.LookAndFeelInfo[] LAFInfo = UIManager.getInstalledLookAndFeels();
        String [] LookAndFeels = new String[LAFInfo.length];
        for (int i = 0; i < LAFInfo.length; i++)
            LookAndFeels [i] =  LAFInfo[i].getName();
        try {
            UIManager.setLookAndFeel(LAF);
       //     SwingUtilities.updateComponentTreeUI(SettingsPanel.this);
        }
        catch (Exception e) {
            System.out.println("1");
        }
        JLabel jl13 = new JLabel(programLang.lang.get(16));
        jl13.setBounds(75,250,220,30);
        settings.add(jl13);
        JComboBox lookAndFeelChoices = new JComboBox<>(LookAndFeels);
        lookAndFeelChoices.setBounds(300,250,120,30);
        lookAndFeelChoices.setSelectedIndex(LAFIndex);
        lookAndFeelChoices.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                //    UIManager.setLookAndFeel(LAFInfo[lookAndFeelChoices.getSelectedIndex()].getClassName());
              //      SwingUtilities.updateComponentTreeUI(SettingsPanel.this);
                    LAF = LAFInfo[lookAndFeelChoices.getSelectedIndex()].getClassName();
                    LAFIndex = lookAndFeelChoices.getSelectedIndex();
                 //   SwingUtilities.updateComponentTreeUI(SettingsPanel.this);
                 //   updateSettingJDMFile();
                }
                catch (Exception ei) {
                    System.out.println("suck");
                }

            }
        });
        //    this.revalidate();
        settings.add(lookAndFeelChoices);

        JTextArea filterSites = new JTextArea(10,10);
        JTextField enteringFilterSites = new JTextField(10);
        JScrollPane filterScrollArea = new JScrollPane(filterSites,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton submitFilterSites = new JButton(programLang.lang.get(18));
        filterScrollArea.setBounds(550,60,150,150);
        add(filterScrollArea);
        enteringFilterSites.setBounds(550,230,150,30);
        submitFilterSites.setBounds(585,280,75, 30);
        for (int i = 0; i < filterSitesList.size(); i++) {
            filterSites.setText(filterSites.getText() + String.format("%s\n",filterSitesList.get(i)));
        }
        submitFilterSites.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterSitesList.add(enteringFilterSites.getText());
                filterSites.setText(filterSites.getText() + String.format("%s\n",enteringFilterSites.getText()));
            }
        });
        add(submitFilterSites);
        add(enteringFilterSites);
        JLabel langLabel = new JLabel(programLang.lang.get(24));
        String[] langs = new String[] {"English","فارسی"};
        JComboBox<String> choosingLang = new JComboBox<>(langs);
        choosingLang.setSelectedIndex(lang);
        choosingLang.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (choosingLang.getSelectedIndex() == 0) {
                    lang = 0;
                }
                else {
                    lang = 1;
                }
            }
        });
        choosingLang.setBounds(300,320,120,30);
        langLabel.setBounds(75,320,150,30);
        add(choosingLang);
        add(langLabel);
        JPanel separator = new JPanel();
        separator.setBounds(450,45,1,330);
        separator.setBackground(new Color(80,80,80));
        add(separator);
        JPanel separator2 = new JPanel();
        separator2.setBounds(125,120,200,2);
        separator2.setBackground(new Color(62,173,88));
        add(separator2);
        JPanel separator3 = new JPanel();
        separator3.setBounds(125,230,200,2);
        separator3.setBackground(new Color(62,173,88));
        add(separator3);
        JPanel separator4 = new JPanel();
        separator4.setBounds(125,300,200,2);
        separator4.setBackground(new Color(62,173,88));
        add(separator4);
        JButton saveAndApply = new JButton(programLang.lang.get(17));
        saveAndApply.setBounds(380,380,150,30);
        saveAndApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateSettingJDMFile();
                    FileOutputStream fs = new FileOutputStream("filter.jdm");
                    ObjectOutputStream oos = new ObjectOutputStream(fs);
                    oos.writeObject(filterSitesList);
                    oos.flush();
                    oos.close();
                    dispose();
                    c.dispose();
                    MainPage a = new MainPage();

                }
                catch (Exception ei) {
                    System.out.println("2");
                }
            }
        });
        add(saveAndApply);
        add(settings);
        setResizable(true);
        setVisible(false);
    }



    public void updateSettingJDMFile () {
        try {
            FileOutputStream fs = new FileOutputStream("settings.jdm");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(SettingsPanel.this);
            oos.flush();
            oos.close();
        }
        catch (Exception e) {
            System.out.println("3");
        }
    }

    public void retrieveSettings () {
        try {
            FileInputStream fs = new FileInputStream("settings.jdm");
            ObjectInputStream ois = new ObjectInputStream(fs);
            SettingsPanel temp = (SettingsPanel) ois.readObject();
            LAF = temp.LAF;
            numOfConcurrentDownloads = temp.numOfConcurrentDownloads;
            filterSitesList = temp.filterSitesList;
            dc = temp.dc;
            setLAFIndex(temp.getLAFIndex());
            setLang(temp.getLang());
        }
        catch (Exception e) {
            System.out.println("4");
        }
    }

    public DirectoryChooser getDc() {
        return dc;
    }

    public void setDc(DirectoryChooser dc) {
        this.dc = dc;
    }

    public int getNumOfConcurrentDownloads() {
        return numOfConcurrentDownloads;
    }

    public void setNumOfConcurrentDownloads(int numOfConcurrentDownloads) {
        this.numOfConcurrentDownloads = numOfConcurrentDownloads;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public String getLAF() {
        return LAF;
    }

    public void setLAF(String LAF) {
        this.LAF = LAF;
    }

    public ArrayList<String> getFilterSitesList() {
        return filterSitesList;
    }

    public void setFilterSitesList(ArrayList<String> filterSitesList) {
        this.filterSitesList = filterSitesList;
    }

    public int getLAFIndex() {
        return LAFIndex;
    }

    public void setLAFIndex(int LAFIndex) {
        this.LAFIndex = LAFIndex;
    }
}
