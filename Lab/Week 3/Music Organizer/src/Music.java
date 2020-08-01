/**
 * This class represents a music.
 * @author Ali Khorramipour
 * @version 1.0
 */
public class Music {
    private String name;
    private String year;
    private String artist;
    private String address;

    public Music(String name, String year, String artist, String address) {
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.address = address;
    }

    public void print(){
        System.out.println("Name: " + this.name);
        System.out.println("Artist: " + this.artist);
        System.out.println("Year: " + this.year);
        System.out.println("Address: " + this.address);
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public String getAddress() {
        return address;
    }
}
