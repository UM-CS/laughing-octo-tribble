package Creatures;

import java.awt.Color;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanFly;
import Definitions.Terrain;


public class ZogFlyers extends Alien implements CanFly
{
    static int thesize=50;

    public ZogFlyers(int x, int y, int size){
        super("Flyer", x, y, new Random().nextInt(thesize), Color.CYAN); 
    }
    
    public void fly(Terrain[][] map)
    {
        
    }

}