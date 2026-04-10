package Creatures;

import java.awt.Color;
import java.util.Random;
import Definitions.Alien;
import Definitions.CanWalk;
import Definitions.CanSwim;
import Definitions.Terrain;

public class Sauropod extends Alien implements CanWalk, CanSwim{
    int speed = 2;
    int wadingSpeed = 1;

    public Sauropod(int x, int y, int size) {
        super("Saltasaurus", x, y, size, Color.GRAY);
    }

    public void walk(Terrain[][] map) {
        Random rand = new Random();
        int nextX = gridX + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(speed);
        int nextY = gridY + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(speed);

        if(canEnter(nextX, nextY, map)) gridX = nextX;
        else {
            gridY += (rand.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length - 1, gridY));
        }
    }

    public boolean nearSauropod(Terrain[][] map) {
        /*
        This function will check if there is another sauropod around.
        If there is, it will make another Sauropod. 
        */
       return false; // Placeholder
    }

    public void swim(Terrain[][] map) {
        // Sauropods are big and can walk through most bodies of water that aren't ocean

        Random rand = new Random();
        int nextX = gridX + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(wadingSpeed);//Oh wait, can't use a flaot
        int nextY = gridY + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(wadingSpeed);

        if(canEnter(nextX, nextY, map)) gridX = nextX;
        else {
            gridY += (rand.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length - 1, gridY));
        }
    }
}