package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanSwim;
import Definitions.CanWalk;
import Definitions.Terrain;

public class Blobster extends Alien implements CanWalk, CanSwim{ //Unfortunately Blob is a reserved term
    
    public Blobster(int x, int y, int size) {
        super("Blob", x, y, size, Color.RED);
    }

    public void walk(Terrain[][] map){
        Random r = new Random();
        int nextX = gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(5);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(5);
        if (canEnter(nextX, nextY, map)){
            gridX = nextX;
        }
        else{
            // super("Blob", x, y, (size/2), Color.GRAY); 
            gridY += (r.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length-1, gridY));
        }

    }

    @Override
    public void swim(Terrain[][] map) {
        
    }
}
