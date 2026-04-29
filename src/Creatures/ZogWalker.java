package Creatures;

import java.awt.Color;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Definitions.Alien;
import Definitions.CanWalk;
import Definitions.Terrain;

public class ZogWalker extends Alien implements CanWalk {
    int speed = 2;

    public ZogWalker(int x, int y, int size) { 
        super("Walker", x, y, size, Color.GREEN, "src/assets/Zog.png"); 
    }


    @Override
    public void walk(Terrain[][] map) {
        walk(map, "src/assets/ElevenLabs_Heavy_boots_stomping_through_thick_mud,_gritty_texture.wav");
    }

    @Override
    public void walk(Terrain[][] map, String soundPath) {
        Clip clip = null;
        try{
            File file = new File(soundPath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        }catch(Exception e){

        }

        Random r = new Random();
        int nextX = gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(speed);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(speed);
        
        if (canEnter(nextX, nextY, map)) {
            gridX = nextX;
        } else {
            // clip.start();
            // If they hit a river and can't swim, they just pace up and down
            gridY += (r.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length-1, gridY));
        }

        clip.close();

    }

    
}