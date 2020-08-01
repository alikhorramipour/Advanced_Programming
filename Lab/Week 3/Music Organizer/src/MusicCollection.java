import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Klling
 * @version 2011.07.31
 */
public class MusicCollection {
    // An ArrayList for storing the file names of music files.
    private ArrayList<Music> files;

    //Iterator for ArrayList.
    private Iterator<Music> it;

    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection() {
        player = new MusicPlayer();
        files = new ArrayList<Music>();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(Music msc) {
        files.add(msc);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles() {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index) {
        System.out.println(files.get(index));
    }
    
    /**
     * Show a list of all the files in the collection.
     */
    public void listAllFiles() {
        for(int i = 0; i < files.size(); i++){
            files.get(i).print();
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index) {
        files.remove(index);
    }

    public void search(String input){
        for(int i = 0; i < files.size(); i++)
            if( (files.get(i).getName().equals(input)) || (files.get(i).getYear().equals(input)) || (files.get(i).getArtist().equals(input)) || (files.get(i).getAddress().equals(input)) )
                files.get(i).print();
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index) {
        player.startPlaying(files.get(index));
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stopPlaying();
    }


    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        // The return value.
        // Set according to whether the index is valid or not.
        if(index < files.size() && index >= 0)
            return true;
        return false;
    }
}