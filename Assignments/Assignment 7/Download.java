import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class Download implements Serializable {
    private String fileName;
    private String hostName;
    private boolean removed = false;
    private double downloadSpeed;
    private double downloadedSize;
    private double sizeOfFile;
    LocalTime downloadTime;
    LocalDate downloadDate;
    private boolean checked = false;
    private static final long serialVersionUID = 1113799434508676095L;
    JLabel test = new JLabel("test");
    private int correspondingList;
    public static final int CURRENT = 0;
    public static final int COMPLETE = 1;
    public static final int QUEUE = 2;
    public static final int SCHEDULE = 3;
    public static final int REMOVED = 4;


    public Download (MainPage c,URL url,LocalTime time,LocalDate date) {


        downloadDate = date;
        downloadTime = time;
        fileName = url.getFile();
        hostName = url.getHost();
        Random r = new Random();
        double lower = 0;
        double upper = 999.99;
        sizeOfFile = Math.random() * (upper - lower) + lower;
        downloadSpeed = Math.random() * (upper - lower) + lower;
        downloadedSize = ((double) r.nextInt(100)) * sizeOfFile / 100.00;
        JLabel downloadSpeedLabel = new JLabel (String.format ("%.1fKbs",downloadSpeed));
        JLabel downloadedSizeLabel = new JLabel (String.format ("%.1fMG / %.2fMG",downloadedSize,sizeOfFile));
        downloadedSizeLabel.setForeground(new Color(109,111,114));
        downloadSpeedLabel.setForeground(new Color(109,111,114));
        downloadSpeedLabel.setBounds(250,35,100,30);
        downloadedSizeLabel.setBounds(420,35,150,30);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public double getDownloadSpeed() {
        return downloadSpeed;
    }

    public void setDownloadSpeed(double downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public double getDownloadedSize() {
        return downloadedSize;
    }

    public void setDownloadedSize(double downloadedSize) {
        this.downloadedSize = downloadedSize;
    }

    public double getSizeOfFile() {
        return sizeOfFile;
    }

    public void setSizeOfFile(double sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public LocalTime getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(LocalTime downloadTime) {
        this.downloadTime = downloadTime;
    }

    public LocalDate getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(LocalDate downloadDate) {
        this.downloadDate = downloadDate;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public JLabel getTest() {
        return test;
    }

    public void setTest(JLabel test) {
        this.test = test;
    }

    public int getCorrespondingList() {
        return correspondingList;
    }

    public void setCorrespondingList(int correspondingList) {
        this.correspondingList = correspondingList;
    }
}
