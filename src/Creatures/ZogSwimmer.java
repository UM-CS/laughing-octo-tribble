package Creatures;

import Definitions.Alien;
import Definitions.CanSwim;
import Definitions.CanWalk;
import Definitions.Terrain;
import java.awt.Color;
import java.util.Random;

public class ZogSwimmer extends Alien implements CanSwim, CanWalk {
   int WaterSpeed = 3;
   int LandSpeed = 1;

   public ZogSwimmer(int x, int y, int size) {
      super("WaterZog", x, y, size, Color.PINK);
      //test
   }
   
   @Override
   public void swim(Terrain[][] map) {

      Random r = new Random();
      int nextX = this.gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.WaterSpeed);
      int nextY = this.gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.WaterSpeed);
      if (this.canEnter(nextX, nextY, map)) {
         this.gridX = nextX;
      }

   }

   @Override
   public void walk(Terrain[][] map){
      Random r = new Random();
      int nextX = this.gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.LandSpeed);
      int nextY = this.gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.LandSpeed);
      if(this.canEnter(nextX, nextY, map)){
         this.gridX = nextX;
      }
   }
}