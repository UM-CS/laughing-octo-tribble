package Creatures;

import Definitions.Alien;
import Definitions.CanWalk;
import Definitions.Terrain;
import java.awt.Color;
import java.util.Random;

public class Landstrider extends Alien implements CanWalk {

    int speed = 8;
    int size = 7;

    public Landstrider(int x, int y, int size) {
        super("Strider", x, y, size, Color.ORANGE);
    }

    @Override
    public void walk(Terrain [][] map) { 
        Random r = new Random();

        int nextX = gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(speed);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(speed);
        
        if (canEnter(nextX, nextY, map)) {
            gridX = nextX;
        } else {
            gridY += (r.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length-1, gridY));
        }
    }

    
}