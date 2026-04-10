package Definitions;

import java.awt.*;


public class Alien {
    protected int gridX, gridY;
    int size;
    Color color;
    String name;

    public Alien(String name, int x, int y, int size, Color color) {
        this.name = name;
        this.gridX = x; 
        this.gridY = y;
        this.size = size; 
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        int drawX = gridX * 15 + 4;
        int drawY = gridY * 15 + 4;
        int drawSize = size - 8;
        g.fillRoundRect(drawX, drawY, drawSize, drawSize, 10, 10);
        g.setFont(new Font("SansSerif", Font.PLAIN, 9));
        g.setColor(Color.WHITE); 
        g.drawString(name, drawX + 2, drawY + (drawSize / 2) + 5);
    }

    // Helper to validate moves based on Interfaces
    protected boolean canEnter(int targetX, int targetY, Terrain[][] map) {
        if (targetX < 0 || targetY < 0 || targetX >= map.length || targetY >= map[0].length) return false;
        
        Terrain t = map[targetX][targetY];
        if (t == Terrain.GROUND) return true;
        if (t == Terrain.RIVER && (this instanceof CanSwim || this instanceof CanFly || this instanceof CanTeleport)) return true;
        if (t == Terrain.VOID && (this instanceof CanFly || this instanceof CanTeleport)) return true;
        
        return false; // Cannot enter!
    }
}