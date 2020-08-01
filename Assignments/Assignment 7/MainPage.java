import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import static javafx.scene.input.KeyCode.J;
import static javafx.scene.input.KeyCode.M;

public class MainPage extends JFrame {

    ArrayList<DownloadList> lists = new ArrayList<>();
    GridLayout gl = new GridLayout();
    JScrollPane jsp = new JScrollPane();
    ObjectInputStream ois;

    public MainPage () {
        SettingsPanel s = new SettingsPanel(null);
        Language programLang = new Language();
        if (s.getLang() == 0)
            programLang.mainLangToEng();
        else
            programLang.mainLangToFarsi();
        try {
      /*  FileInputStream fs = new FileInputStream("settings.jdm");
        ObjectInputStream ois = new ObjectInputStream(fs);
        String temp = ((SettingsPanel) ois.readObject()).getLAF();
        System.out.println(temp); */
        UIManager.setLookAndFeel(s.getLAF());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        lists.add(new DownloadList("list.jdm"));   // current downloads
        lists.add(new DownloadList("completed.jdm"));   // completed
        lists.add(new DownloadList("queue.jdm"));   // queue
        lists.add(new DownloadList("schedule"));   // schedule
        lists.add(new DownloadList("removed.jdm")); // removed downloads

        // creating menus and menuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu downloadMenu = new JMenu(programLang.lang.get(0));
        JMenuItem help = new JMenuItem(programLang.lang.get(7));
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Help frame = new Help();
            }
        });
        JMenuItem download = new JMenuItem(programLang.lang.get(0));
        download.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NewDownload a = new NewDownload(MainPage.this);
                }
                catch (Exception el) {
                    System.out.println(el);
                }
            }
        });
        JMenuItem pause = new JMenuItem(programLang.lang.get(1));
        JMenuItem resume = new JMenuItem(programLang.lang.get(2));
        JMenuItem cancel = new JMenuItem(programLang.lang.get(3));
        JMenuItem remove = new JMenuItem(programLang.lang.get(4));
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i).isFocus()) {
                        removeSelectedItems(lists.get(i));
                        lists.get(i).updateJDMFile(lists.get(i).getFileName());
                        lists.get(4).updateJDMFile(lists.get(4).getFileName());
                    }
                }

            }
        });
        JMenuItem settings = new JMenuItem(programLang.lang.get(5));
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsPanel s = new SettingsPanel(MainPage.this);
                s.setVisible(true);
            }
        });
        JMenuItem exit = new JMenuItem(programLang.lang.get(6));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        menuBar.add(downloadMenu);
        menuBar.add(help);
        downloadMenu.add(download);
        downloadMenu.add(pause);
        downloadMenu.add(resume);
        downloadMenu.add(cancel);
        downloadMenu.add(remove);
        downloadMenu.add(settings);
        downloadMenu.add(exit);
        setJMenuBar(menuBar);

        // creating toolbar

        JButton[] toolBarButtons = new JButton[10];
        JToolBar mainToolBar = new JToolBar();
        toolBarButtons[0] = new JButton(new ImageIcon("icons/download.png"));
        toolBarButtons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    NewDownload a = new NewDownload(MainPage.this);
                }
                catch (Exception el) {
                    System.out.println(el);
                }
            }
        });
        toolBarButtons[1] = new JButton(new ImageIcon("icons/pause.png"));
        toolBarButtons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        toolBarButtons[2] = new JButton(new ImageIcon("icons/resume.png"));
        toolBarButtons[3] = new JButton(new ImageIcon("icons/cancel.png"));
        toolBarButtons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.updateComponentTreeUI(MainPage.this);
            }
        });
        toolBarButtons[4] = new JButton(new ImageIcon("icons/remove.png"));
        toolBarButtons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < lists.size(); i++) {
                    if (lists.get(i).isFocus()) {
                        removeSelectedItems(lists.get(i));
                        lists.get(i).updateJDMFile(lists.get(i).getFileName());
                        lists.get(4).updateJDMFile(lists.get(4).getFileName());
                    }
                }
            }
        });
        toolBarButtons[5] = new JButton(new ImageIcon("icons/settings.png"));
        toolBarButtons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsPanel s = new SettingsPanel(MainPage.this);
                s.setVisible(true);
            }
        });
        toolBarButtons[6] = new JButton(new ImageIcon("icons/sort.png"));
        toolBarButtons[6].addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JPopupMenu sortMenu = new JPopupMenu();
                JMenu time = new JMenu("By Time");
                JMenuItem timeUp = new JMenuItem("UP");
                timeUp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < lists.size();i++) {
                            if (lists.get(i).isFocus()) {
                                lists.get(i).sortTime(1);
                                showList(lists.get(i).getArr());
                            }
                        }
                    }
                });
                JMenuItem timeDown = new JMenuItem("Down");
                timeDown.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < lists.size();i++) {
                            if (lists.get(i).isFocus()) {
                                lists.get(i).sortTime(-1);
                                showList(lists.get(i).getArr());
                            }
                        }
                    }
                });
                JMenu alphabetically = new JMenu("By Name");
                JMenuItem alphabeticallyUp = new JMenuItem("UP");
                alphabeticallyUp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < lists.size();i++) {
                            if (lists.get(i).isFocus()) {
                                lists.get(i).sortAlphabetically(1);
                                showList(lists.get(i).getArr());
                            }
                        }
                    }
                });
                JMenuItem alphabeticallyDown = new JMenuItem("Down");
                alphabeticallyDown.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < lists.size();i++) {
                            if (lists.get(i).isFocus()) {
                                lists.get(i).sortAlphabetically(-1);
                                showList(lists.get(i).getArr());
                            }
                        }
                    }
                });
                JMenu size = new JMenu("By Size");
                JMenuItem sizeUp = new JMenuItem("UP");
                sizeUp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < lists.size();i++) {
                            if (lists.get(i).isFocus()) {
                                lists.get(i).sortSize(1);
                                showList(lists.get(i).getArr());
                            }
                        }
                    }
                });
                JMenuItem sizeDown = new JMenuItem("Down");
                sizeDown.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < lists.size();i++) {
                            if (lists.get(i).isFocus()) {
                                lists.get(i).sortSize(-1);
                                showList(lists.get(i).getArr());
                            }
                        }
                    }
                });
                sortMenu.add(time);
                time.add(timeUp);
                time.add(timeDown);
                sortMenu.add(alphabetically);
                alphabetically.add(alphabeticallyUp);
                alphabetically.add(alphabeticallyDown);
                sortMenu.add(size);
                size.add(sizeUp);
                size.add(sizeDown);
                sortMenu.show(e.getComponent(),e.getX(),e.getY());
            }
        });
        for (int i = 0; i < 7; i++)
            mainToolBar.add(toolBarButtons[i]);
        for (int i = 0; i < 7; i++) {
            toolBarButtons[i].setFocusPainted (false);
            toolBarButtons[i].setBorderPainted(false);
            toolBarButtons[i].setContentAreaFilled(false);
            toolBarButtons[i].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
            toolBarButtons[i].setOpaque(false);
        }
        mainToolBar.setFloatable(false);
        mainToolBar.setOrientation(0);


    //    mainToolBar.add(search);
        mainToolBar.add(Box.createHorizontalGlue());


        JButton jb = new JButton(new ImageIcon("icons/search.png"));
        jb.setBorderPainted(false);
        jb.setFocusPainted(false);
        jb.setContentAreaFilled(false);
        jb.setOpaque(false);
        JTextField search = new JTextField("Search and Enter",5);
     //   search.setLocation(jb.getX(),jb.getY());
        search.setVisible(false);
        mainToolBar.add(search);
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mouseEntered(e);
                if (search.isVisible()) {
                    search.setVisible(false);
                    search.setText("");
                    SwingUtilities.updateComponentTreeUI(MainPage.this);
                }
                else {
                    search.setVisible(true);
                    SwingUtilities.updateComponentTreeUI(MainPage.this);
                }
            }

        }
        );
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            ArrayList<Download> temp = new ArrayList<>();
                for (int i = 0; i < lists.size();i++) {
                    if (lists.get(i).isFocus()) {
                        for (int j = 0; j < lists.get(i).getArr().size(); j++) {
                            if (lists.get(i).getArr().get(j).getFileName().contains(search.getText()) || lists.get(i).getArr().get(j).getHostName().contains(search.getText())) {
                                temp.add(lists.get(i).getArr().get(j));
                            }
                        }
                    }
                }
                showList(temp);
            }
        });
        mainToolBar.add(jb);
        add(mainToolBar,BorderLayout.PAGE_START);

    // creating left list

        JLabel q = new JLabel(programLang.lang.get(10));
        q.setIcon(new ImageIcon("queue.png"));
        q.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                changeFocus(2);
                showList(lists.get(2).getArr());
            }
        });
        JLabel completed = new JLabel(programLang.lang.get(9));
        completed.setIcon(new ImageIcon("completed.png"));
        completed.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                changeFocus(1);
                showList(getLists().get(1).getArr());
            }
        });
        JLabel processing = new JLabel(programLang.lang.get(8));
        processing.setIcon(new ImageIcon("processing.png"));
        processing.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                changeFocus(0);
                showList(getLists().get(0).getArr());
            }
        });
        JLabel schedule = new JLabel(programLang.lang.get(11));
        schedule.setIcon(new ImageIcon("schedule.png"));
        schedule.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                changeFocus(3);
                showList(getLists().get(3).getArr());
            }
        });
        JLabel trashBin = new JLabel(programLang.lang.get(12));
    //    trashBin.setIcon(new ImageIcon("schedule.png"));
        trashBin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                changeFocus(4);
                showList(getLists().get(4).getArr());
            }
        });
        JPanel leftMenu = new JPanel(new GridLayout(8,1));
        leftMenu.setPreferredSize(new Dimension(100,500));
        leftMenu.add(processing);
        leftMenu.add(completed);
        leftMenu.add(q);
        leftMenu.add(schedule);
        leftMenu.add(trashBin);
        add(leftMenu,BorderLayout.WEST);

   // creating main panel for downloads

        //retrieving previousDownloads and settings
       try {
        //    ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("list.jdm")));
            lists.get(0).retrieving(lists.get(0).getFileName());
            lists.get(1).retrieving(lists.get(1).getFileName());
            lists.get(2).retrieving(lists.get(2).getFileName());
            lists.get(3).retrieving(lists.get(3).getFileName());
            lists.get(4).retrieving(lists.get(4).getFileName());
            showList(lists.get(0).getArr());
            lists.get(0).setFocus(true);

        //    SwingUtilities.updateComponentTreeUI(MainPage.this);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        // general settings for the app

        setSize(750,530);
    //    setResizable(false);

        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent windowEvent) {
                TrayIconDemo tray = new TrayIconDemo();
                tray.createAndShowGUI(MainPage.this);
                MainPage.this.setVisible(false);
            }
        });

        UIManager.put("swing.boldMetal", Boolean.FALSE);
        setVisible(true);
    }

    public void updateList () {
     /*   for (int i = 0; i < getCurrentDownloads().size(); i++) {
            if (getCurrentDownloads().get(i).getDownload().isRemoved()) {
                getCurrentDownloads().remove(i);
            }
        } */
    /*    for (int i = 0; i < getQueue().size(); i++) {
            if (getQueue().get(i).isRemoved()) {
                getQueue().remove(i);
            }
        } */
      /*  for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).isRemoved()) {
                arr.remove(i);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).isRemoved()) {
                arr.remove(i);
            }
        }
        */
    }

   public void removeSelectedItems (DownloadList arr) {
        int size = arr.getArr().size();
        int numOfCheckedItems = 0;
        if (arr.getFileName().equals("removed.jdm")) {
            for (int i = 0; i < size; i++) {
                if (arr.getArr().get(i - numOfCheckedItems).isChecked()) {
                    arr.getArr().get(i - numOfCheckedItems).setCorrespondingList(4);
                    arr.getArr().remove(i - numOfCheckedItems);
                    numOfCheckedItems++;
                }
            }
            showList(arr.getArr());
        }
        else {
            for (int i = 0; i < size; i++) {
                if (arr.getArr().get(i - numOfCheckedItems).isChecked()) {
                    arr.getArr().get(i - numOfCheckedItems).setCorrespondingList(4);
                    lists.get(4).getArr().add(arr.getArr().get(i - numOfCheckedItems));
                    arr.getArr().remove(i - numOfCheckedItems);
                    numOfCheckedItems++;
                }
            }
            showList(arr.getArr());
        }
    }

    public void showList (ArrayList<Download> arr) {
        remove(jsp);
        gl.setRows(3 + arr.size());
        JPanel temp = new JPanel(gl);
        for (int i = 0; i < arr.size(); i++) {
            temp.add(new DownloadPanel(arr.get(i),MainPage.this));
        }
        jsp.getViewport().add(temp);
        add(jsp,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(MainPage.this);
    }

    public  void retrievingDownloadLists (DownloadList arr, String filename) {

        arr.retrieving(filename);
    }

    public void changeFocus (int i) {
        for (int j = 0; j < lists.size(); j++) {
            lists.get(j).setFocus(false);
        }
        lists.get(i).setFocus(true);
    }

    public ArrayList<DownloadList> getLists() {
        return lists;
    }

    public void setLists(ArrayList<DownloadList> lists) {
        this.lists = lists;
    }
}

