package Creatures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
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

    public boolean reproduce(List<Alien> x)
    {
        for(Alien a : x)
        {
            if(isWithinTwoUnits(a.getX(), a.getY(), gridY, gridX) && a.getClass()==ZogFlyers.class)
            {
                return true;
            }
        }
        return false;
    }


    public static boolean isWithinTwoUnits(int x1, int y1, int x2, int y2) 
    {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return (dx * dx + dy * dy) <= 4; 
    }
}