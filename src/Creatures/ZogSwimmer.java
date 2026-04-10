package Creatures;

import Definitions.Alien;
import Definitions.CanSwim;
import Definitions.Terrain;
import java.awt.Color;
import java.util.Random;

public class ZogSwimmer extends Alien implements CanSwim {
   int WaterSpeed = 2;

   public ZogSwimmer(int x, int y, int size) {
      super("WaterZog", x, y, size, Color.PINK);
   }
   
   public void swim(Terrain[][] map) {

      Random r = new Random();
      int nextX = this.gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.WaterSpeed);
      int nextY = this.gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.WaterSpeed);
      if (this.canEnter(nextX, nextY, map)) {
         this.gridX = nextX;
      }

   }
}