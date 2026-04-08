package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanSwim;
import Definitions.Terrain;

public class RoboSwimmer extends Alien implements CanSwim {
    int swimSpeed = 4;

    public RoboSwimmer(int x, int y, int size) {
        super("Babbie", x, y, size, Color.PINK);
    };

    public void swim(Terrain[][] map) {
        // Random r = new Random();
        // int nextX = gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(swimSpeed);
        // int nextY = gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(swimSpeed);

        // want to only make him swim

        Random r = new Random();
        int nextX = gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(swimSpeed);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(swimSpeed);
        
        if (canEnter(nextX, nextY, map)) {
            gridX = nextX;
        } else {
            // If they hit a river and can't swim, they just pace up and down
            gridY += (r.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length-1, gridY));
        }

    }
}



