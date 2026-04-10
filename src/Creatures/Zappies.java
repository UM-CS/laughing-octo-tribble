package Creatures;
 
import java.awt.Color;
import java.util.Random;
 
import Definitions.Alien;
import Definitions.CanTeleport;
import Definitions.CanWalk;
import Definitions.Terrain;
 
public class Zappies extends Alien implements CanWalk, CanTeleport{
 
    public Zappies(int x, int y, int size){
        super("Zappies", x, y, size, Color.YELLOW);
    }
 
    public void teleport(Terrain[][] map){
        Random r = new Random();
 
        int newX;
        int newY;
 
        do {
            newX = r.nextInt(map.length);
            newY = r.nextInt(map.length);
        }
        while (!canEnter(newX, newY, map));
 
        gridX = newX;
        gridY = newY;
    }

    @Override
    public void walk(Terrain[][] map){
        Random r = new Random();
        int newX = gridX + r.nextInt();
        int newY = gridY + r.nextInt();
 
        if(canEnter(newX, newY, map)){
            gridX = newX;
            gridY = newY;
        }else{
            teleport(map);
        }
    }
 
}