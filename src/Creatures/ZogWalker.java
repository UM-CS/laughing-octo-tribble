package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanWalk;
import Definitions.Terrain;

public class ZogWalker extends Alien implements CanWalk {
    int speed = 2;

    public ZogWalker(int x, int y, int size) { 
        super("Zog", x, y, size, Color.GREEN); 
    }


    @Override
    public void walk(Terrain[][] map) {
        Random r = new Random();
        int nextX = gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(speed);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(speed);
        
        if (canEnter(nextX, nextY, map)) {
            gridX = nextX;
        } else {
            // If they hit a river and can't swim, they just pace up and down
            gridY += (r.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length-1, gridY));
        }
    }

    
}