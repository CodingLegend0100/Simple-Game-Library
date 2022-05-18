package gamelib;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    Clip clip;

    public Sound(String filepath) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filepath));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (UnsupportedAudioFileException e){
            System.out.println("The file type of "+filepath+" is unsupported!");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("An error occurred while trying to play "+filepath);
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void loop(int count){
        clip.loop(count);
    }
}
