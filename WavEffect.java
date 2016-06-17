package sound;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by caotr on 15/06/2016.
 */
public class WavEffect implements  LineListener {
    private Clip clip;
    private boolean isRun = false;

    public WavEffect(String fileName){
        URL url = getClass().getResource("/audios/"+fileName);
        try {
            clip = AudioSystem.getClip();
            AudioInputStream input = AudioSystem.getAudioInputStream(url);
            clip.open(input);


        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        if(clip.isRunning()){
            return;
        }
        clip.start();
        isRun = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (isRun){
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        });
    }
    public void stop(){
        clip.stop();
        clip.close();
    }

    public void loop(int number){
        clip.loop(number);
    }


    @Override
    public void update(LineEvent event) {
        if(event.getType() == LineEvent.Type.STOP || event.getType() == LineEvent.Type.CLOSE){
            isRun = false;
        }
    }
}
