package gamelib;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;

    public Sound(String filepath) {
        try {
        AudioInputStream ais = AudioSystem.getAudioInputStream(new File(filepath));
        clip = AudioSystem.getClip();
        clip.open(ais);
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
