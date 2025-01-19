import arc.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class testingthisagain {

    public static void main(String[] args) {
        // Create a console window
        Console con = new Console("Array LOL", 1280, 720);
        
        try {
            File file = new File("SoundSquidGame.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
