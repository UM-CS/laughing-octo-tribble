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
        g.fillRoundRect(gridX * 15 + 4, gridY * 15 + 4, size - 8, size - 8, 10, 10);
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