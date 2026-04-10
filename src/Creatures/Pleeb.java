package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanWalk;
import Definitions.CanSwim;
import Definitions.Terrain;

public class Pleeb extends Alien implements CanWalk, CanSwim{
    int landSpeed = 1;
    int waterSpeed = 2;

    public Pleeb(int x, int y, int size){
        super("Plebbles",x, y, size, Color.WHITE);
    }

    public void walk(Terrain[][] map){
        Random rand = new Random();
        int nextX = gridX + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(landSpeed);
        int nextY = gridY + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(landSpeed);

        if(canEnter(nextX,nextY,map)){

            for(int i = 0; i <= 4; i++){
                boolean randY = rand.nextBoolean();
                gridX += nextX;
                gridY += (randY ? 1 : -1);;
                gridX += -nextX;
                gridY += (!randY ? 1 : -1);;   
            }
        }
        else{
            gridX += (rand.nextBoolean() ? 1 : -1);
            gridX = Math.max(0, Math.min(map[0].length-1, gridX));
        }
    }

    public void swim(Terrain[][] map){
        Random rand = new Random();
        int nextX = gridX + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(waterSpeed);
        int nextY = gridY + (rand.nextBoolean() ? 1 : -1) * rand.nextInt(waterSpeed);

        if(canEnter(nextX,nextY,map)){
            gridX = nextX;
            for(int i = 0; i <= 6; i++){
                gridY = -nextY;
                gridY = nextY;
            }
          
        }
        
        
    }
}

