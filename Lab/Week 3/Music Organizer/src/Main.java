/**
 * Main class for executing the program.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Main {
    /**
     * main method of the program
     * @param args
     */
    public static void main(String[] args){

        MusicCollection Pop = new MusicCollection();
        MusicCollection Rock = new MusicCollection();
        MusicCollection Jazz = new MusicCollection();
        MusicCollection Country = new MusicCollection();
        MusicCollection Favorite = new MusicCollection();

        Music msc1 = new Music("msc1", "1994", "Kurt", "c:/");
        Music msc2 = new Music("msc2", "1984", "Roger", "d:/");
        Music msc3 = new Music("msc3", "1920", "LeadBelly", "f:/");

        Rock.addFile(msc1);
        Rock.addFile(msc2);
        Country.addFile(msc3);

        Rock.startPlaying(0);

        Rock.listAllFiles();

        Rock.search("Kurt");

    }
}
