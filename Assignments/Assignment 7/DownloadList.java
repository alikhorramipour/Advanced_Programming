import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DownloadList {

    ArrayList<Download> arr = new ArrayList<>();
    String fileName;
    boolean focus;

    public DownloadList(String fileName) {
        this.fileName = fileName;
        this.focus = false;
    }

    public void retrieving (String fileName) {
        try {
            FileInputStream fs = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fs);
            arr = (ArrayList<Download>) ois.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateJDMFile (String fileName) {
        try {
            FileOutputStream fs = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            oos.writeObject(getArr());
            oos.flush();
            oos.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sortSize (int ascendingOrDescending) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (ascendingOrDescending == 1) {
                    if (arr.get(j).getSizeOfFile() > arr.get(j+1).getSizeOfFile())
                        swap(j, j + 1);
                }
                else {
                    if (arr.get(j).getSizeOfFile() < arr.get(j+1).getSizeOfFile())
                        swap(j, j + 1);
                }
            }
        }
    }

    public void sortAlphabetically (int ascendingOrDescending) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size() - i - 1; j++) {
                if (ascendingOrDescending == 1) {
                    if (arr.get(j).getFileName().substring(1).compareToIgnoreCase(arr.get(j + 1).getFileName().substring(1)) > 0)
                        swap(j, j + 1);
                }
                else {
                    if (arr.get(j).getFileName().substring(1).compareToIgnoreCase(arr.get(j + 1).getFileName().substring(1)) < 0)
                        swap(j, j + 1);
                }
            }
        }
    }

    public void sortTime (int ascendingOrDescending) {
        if (ascendingOrDescending == 1) {
            retrieving("list.jdm");
        }
        else {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < arr.size() - i - 1; j++) {
                    swap(j, j + 1);
                }
            }
        }
    }

        public void swap (int i, int j) {
                Download temp;
                temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }

    public ArrayList<Download> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Download> arr) {
        this.arr = arr;
    }

    public boolean isFocus() {
        return focus;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
