package Creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import Definitions.Alien;
import Definitions.CanFly;
import Definitions.Terrain;


public class ZogFlyers extends Alien implements CanFly
{
    static int thesize=50;
    String name="Flyer";
    Color color= Color.CYAN;

    public ZogFlyers(int x, int y, int size){
        super("Flyer", x, y, new Random().nextInt(thesize), Color.CYAN); 
    }
    
    public void fly(Terrain[][] map)
    {
        Random r = new Random();
        int nextX = gridX + (r.nextBoolean() ? 1 : -1) *r.nextInt(4);
        int nextY = gridY + (r.nextBoolean() ? 1 : -1) *r.nextInt(4);

        if(canEnter(nextX, nextY, map))
        {
            gridX=nextX;
            gridY=nextY;
            
        }    
    }
    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        int drawX = gridX * 15 + 4;
        int drawY = gridY * 15 + 4;
        int drawSize = new Random().nextInt(thesize) ;
        g.fillRoundRect(drawX, drawY, drawSize, drawSize, 10, 10);
        g.setFont(new Font("SansSerif", Font.PLAIN, 9));
        g.setColor(Color.WHITE); 
        g.drawString(name, drawX + 2, drawY + (drawSize / 2) + 5);
    }

}