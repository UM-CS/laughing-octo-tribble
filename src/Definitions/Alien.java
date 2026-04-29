package Definitions;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;


public class Alien implements Serializable{
    protected int gridX, gridY;
    int size;
    Color color;
    String name;
    private transient Image sprite;
    String imageString = null;

    Terrain myFaction = Terrain.VOID;

    public String getRandomName() throws IOException{ //Lets try this again
        ArrayList<String> names = new ArrayList<>();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("src/names.txt"));

            String line;

            while((line = reader.readLine()) != null){
                names.add(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if(reader != null) reader.close();
        }

        Random random = new Random();

        return names.get(random.nextInt(names.size()-1));
    }

    public Alien(String name, int x, int y, int size, Color color) {
        try {
            this.name = getRandomName();
        } catch (Exception e) {
            this.name = name;
        }
        this.gridX = x; 
        this.gridY = y;
        this.size = size; 
        this.color = color;
    }

    public Alien(String name, int x, int y, int size, Color color, String imageString) {
        try {
            this.name = getRandomName();
            this.sprite = new ImageIcon(imageString).getImage();
        } catch (Exception e) {
            this.name = name;
        }
        this.imageString = imageString;
        this.gridX = x; 
        this.gridY = y;
        this.size = size; 
        this.color = color;
    }


    public void draw(Graphics g) {
        if(sprite != null){
            g.drawImage(sprite, gridX * 15 + 4, gridY * 15 + 4,size,size, null);
        }else{
            g.setColor(color);
            int drawX = gridX * 15 + 4;
            int drawY = gridY * 15 + 4;
            int drawSize = size - 8;
            g.fillRoundRect(drawX, drawY, drawSize, drawSize, 10, 10);
            g.setFont(new Font("SansSerif", Font.PLAIN, 12));
            g.setColor(Color.WHITE); 
            g.drawString(name, drawX + 2, drawY + (drawSize / 2) + 5);
        }
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

    public int getX()
    {
        return gridX;
    }

      public int getY()
    {
        return gridY;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        if (imageString != null) {
            this.sprite = new ImageIcon(imageString).getImage();
        }
    }

}