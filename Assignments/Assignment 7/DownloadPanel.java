import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;
import java.awt.*;

public class DownloadPanel extends JPanel implements Serializable{

    Download download;

    public DownloadPanel (Download d,MainPage c) {
        SettingsPanel s = new SettingsPanel(null);
        Language programLang = new Language();
        System.out.println(s.getLang());
        if (s.getLang() == 0)
            programLang.mainLangToEng();
        else
            programLang.mainLangToFarsi();
        download = d;
        setLayout(null);
   /*     downloadDate = date;
        downloadTime = time;
        fileName = url.getFile(); */
        JCheckBox checkbox = new JCheckBox();
        checkbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    download.setChecked(true);
                else
                    download.setChecked(false);
            }
        });
        checkbox.setBackground(new Color(186,212,215));
        checkbox.setBounds(95,42,17,15);
        add(checkbox);
        MouseAdapter a = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(new Color(224,235,252));
                checkbox.setBackground(new Color(224,235,252));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(new Color(186,212,255));
                checkbox.setBackground(new Color(186,212,255));
            }
        };
        UIManager.put("ProgressBar.background", new Color (235,255,255));
        UIManager.put("ProgressBar.foreground", new Color (10,109,63));
        UIManager.put("ProgressBar.selectionBackground", Color.RED);
        UIManager.put("ProgressBar.selectionForeground", Color.GREEN);
        setBackground(new Color(186,212,255));
        setPreferredSize(new Dimension(600,105));
        JPanel file = new JPanel();
        test fileImg = new test("file.png");
        fileImg.setBounds(10,10,40,50);
        add(fileImg);
        JLabel fileNameLabel = new JLabel(download.getFileName());
        fileNameLabel.setBounds(100,5,400,15);
        fileNameLabel.setForeground(new Color(109,111,114));
        add(fileNameLabel);
        JProgressBar jpb = new JProgressBar(0,100);
        Random r = new Random();
        jpb.setValue( (int) ((download.getDownloadedSize() / download.getSizeOfFile()) * 100)) ;
        jpb.setBounds(100,25,400,10);
        JLabel progressBarValue = new JLabel("%" + jpb.getValue() + "");
        progressBarValue.setBounds(510,18,25,20);
        add(progressBarValue);
        this.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(18,42,79)));
        addMouseListener(a);
        add(jpb);
        JButton trash = new JButton(new ImageIcon("trash.png"));
        trash.setBounds(130,40,25,25);
        trash.setContentAreaFilled(false);
        trash.setFocusPainted (false);
        trash.setBorderPainted(false);
        trash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setRemoved(true);
                d.setCorrespondingList(4);
                try {
                   // if (i != 4)

                        if (c.getLists().get(4).getArr().contains(d))
                            c.getLists().get(4).getArr().remove(d);
                        c.getLists().get(4).getArr().add(d);





                          //      System.out.println(i + "   " + j);
                                for (int i = 0; i < c.getLists().size(); i++)
                                    if (c.getLists().get(i).isFocus()) {
                                        c.getLists().get(i).getArr().remove(d);
                                        c.getLists().get(i).updateJDMFile(c.getLists().get(i).getFileName());
                                        c.getLists().get(4).updateJDMFile(c.getLists().get(4).getFileName());
                                        c.showList(c.getLists().get(i).getArr());
                                    }



                }
                catch (Exception ei) {
                    ei.printStackTrace();
                }
            }
        });
        add(trash);
        JButton addToQueue = new JButton(new ImageIcon("icons/addtoqueue.png"));
        addToQueue.setContentAreaFilled(false);
        addToQueue.setFocusPainted (false);
        addToQueue.setBorderPainted(false);
        addToQueue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setCorrespondingList(Download.QUEUE);
                c.getLists().get(2).getArr().add(d);
                c.getLists().get(0).getArr().remove(d);
                c.showList(c.getLists().get(0).getArr());
                c.getLists().get(0).updateJDMFile(c.getLists().get(0).getFileName());
                c.getLists().get(2).updateJDMFile(c.getLists().get(2).getFileName());
            }
        });
        addToQueue.setBounds(165,40,25,25);
        add(addToQueue);
        if (d.getCorrespondingList() != Download.CURRENT) {
            addToQueue.setVisible(false);
        }
        JLabel downloadSpeedLabel = new JLabel (String.format ("%.1fKbs",download.getDownloadSpeed()));
        JLabel downloadedSizeLabel = new JLabel (String.format ("%.1fMG / %.2fMG",download.getDownloadedSize(),download.getSizeOfFile()));
        downloadedSizeLabel.setForeground(new Color(109,111,114));
        downloadSpeedLabel.setForeground(new Color(109,111,114));
        downloadSpeedLabel.setBounds(250,35,100,30);
        downloadedSizeLabel.setBounds(420,35,150,30);
        add(downloadSpeedLabel); add(downloadedSizeLabel);
    }

    public Download getDownload() {
        return download;
    }

    public void setDownload(Download download) {
        this.download = download;
    }
}
