package ChubbyMan;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {

    private Clip clip;
    private URL soundURL;
    private String string;
    public Sound(String string) {
        this.string = string;
        initClip(string);
    }


    public void play() {
        this.clip.start();
    }
    public void stop() {
        this.clip.stop();
    }
    public void close() {
        this.clip.close();
    }
    public int getLength() {
        return this.clip.getFrameLength();
    }
    public void loopIndef() {
        this.clip.setLoopPoints(0, (int)((double)this.getLength() * 0.94D));
        this.clip.loop(-1);
    }
    public void reOpen() {
        try {
            AudioInputStream var1 = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip.open(var1);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void initClip(String string) {
        this.soundURL = Sound.class.getResource(string);
        try {
            if (this.soundURL == null) {
                string = string.substring(1);
                File var3 = new File(string);
                this.soundURL = var3.toURI().toURL();
            }
            AudioInputStream audio = AudioSystem.getAudioInputStream(this.soundURL);
            this.clip = AudioSystem.getClip();
            this.clip.open(audio);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException var4) {
            System.out.println(var4.getMessage());
        }
    }
}

