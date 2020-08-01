package ceit.aut.ac.ir.utils;

import ceit.aut.ac.ir.model.Note;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileUtils {

    private static final String NOTES_PATH = "./notes/";

    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }


    public static String fileReader(Note note) {
        try(FileInputStream in = new FileInputStream("./notes/" + note.getTitle() + ".txt")) {
            ObjectInputStream fs = new ObjectInputStream(in);
            Note note1 = (Note) fs.readObject();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "what";
    }

    public static void fileWriter(Note note) {
        try(FileOutputStream out = new FileOutputStream("./notes/" + getProperFileName(note.getTitle()) + ".txt")){
            ObjectOutputStream os = new ObjectOutputStream(out);
            os.writeObject(note);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //TODO: Phase2: proper methods for handling serialization
    public static void fileWriterSer() {
        try(FileOutputStream fos = new FileOutputStream("note.bin")){

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(fos);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Note fileReaderSer() {
        try(FileInputStream fis = new FileInputStream("note.bin")){

            ObjectInputStream ois = new ObjectInputStream(fis);

            Note note1 = (Note) ois.readObject();

            return note1;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
