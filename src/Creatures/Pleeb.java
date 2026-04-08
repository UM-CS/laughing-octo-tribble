package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanWalk;
import Definitions.CanSwim;
import Definitions.Terrain;

public class Pleeb extends Alien implements CanWalk, CanSwim{
    int landSpeed = 1;
    int waterSpeed = 3;

    public Pleeb(int x, int y, int size){
        super("Plebbles",x, y, size, Color.WHITE);
    }


    public void walk(Terrain[][] map){
        Random rand = new Random();
        int nextX = gridX + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(landSpeed);
        int nextY = gridY + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(landSpeed);

        if(canEnter(nextX,nextY,map)){
            gridX = nextX;
        }
        
    }

    public void swim(Terrain[][] map){
        Random rand = new Random();
        int nextX = gridX + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(waterSpeed);
        int nextY = gridY + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(waterSpeed);

        if(canEnter(nextX,nextY,map)){
            gridX = nextX;
        }
        else{
            gridY += (rand.nextBoolean() ? 1 : -1);
            gridY = Math.max(0, Math.min(map[0].length-1, gridY));
        }
    }
}

