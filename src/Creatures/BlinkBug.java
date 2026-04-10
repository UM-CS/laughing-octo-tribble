package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanTeleport;
import Definitions.CanWalk;
import Definitions.Terrain;

public class BlinkBug extends Alien implements CanTeleport, CanWalk {

    public BlinkBug(int x, int y, int size) {
        super("BlinkBug", x, y, size, Color.MAGENTA);
    }

    @Override
    public void teleport(Terrain[][] map) {
        Random r = new Random();

        int newX;
        int newY;

        do {
            newX = r.nextInt(map.length);
            newY = r.nextInt(map[0].length);
        } while (!canEnter(newX, newY, map));

        gridX = newX;
        gridY = newY;
    }

    @Override
    public void walk(Terrain[][] map) {
        Random r = new Random();

        int nextX = gridX + (r.nextBoolean() ? 1 : -1);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1);

        if (canEnter(nextX, nextY, map)) {
            gridX = nextX;
            gridY = nextY;
        }
    }
}