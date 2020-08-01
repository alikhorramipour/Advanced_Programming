package game;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {

    private Clip audioClip;
    private File audioFile;
    private String audioFilePath;
    private boolean played; //
    private int loop; // indicates how many times the file has to be played
    private double audioLength; // how long the track is in seconds

    public AudioPlayer(String audioFilePath, int loop, double audioLength, Clip audioClip) {
        this.audioFile = new File(audioFilePath);
        this.played = false;
        this.loop = loop;
        this.audioLength = audioLength;
        this.audioClip = audioClip;
    }

    public void playAudio(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
            audioClip.loop(loop);
            /* //wait for the playback to complete
            try {
                Thread.sleep((int) trackLength *(loop+1)*1000);//The amount of time the track need to be playing!
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }*/
        } catch (UnsupportedAudioFileException e) {
            System.out.println("The specified audio file is not supported.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.out.println("Audio line for playing back is unavailable.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error playing the audio file.");
            e.printStackTrace();
        }
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed() {
        this.played = true;
        audioClip.close();
    }
}
