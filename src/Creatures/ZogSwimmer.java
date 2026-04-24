package Creatures;

import Definitions.Alien;
import Definitions.CanSwim;
import Definitions.CanWalk;
import Definitions.Terrain;
import java.awt.Color;
import java.util.Random;

public class ZogSwimmer extends Alien implements CanSwim, CanWalk {
   int WaterSpeed = 8;
   int LandSpeed = 2;

   public ZogSwimmer(int x, int y, int size) {
      super("WaterZog", x, y, size, Color.PINK);
      //test
   }
   
   @Override
   public void swim(Terrain[][] map) {
      if (map[gridX][gridY] != Terrain.RIVER) return; 
      Random r = new Random();
      int nextX = this.gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.WaterSpeed);
      int nextY = this.gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.WaterSpeed);
      if (this.canEnter(nextX, nextY, map)) {
         this.gridX = nextX;
         this.gridY = nextY;
      }
      else {
         this.gridY += (r.nextBoolean() ? 1 : -1);
         this.gridY = Math.max(0, Math.min(map[0].length - 1, this.gridY));
      }

   }

   @Override
   public void walk(Terrain[][] map){
      if (map[gridX][gridY] != Terrain.GROUND) return; 
      Random r = new Random();
      int nextX = this.gridX + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.LandSpeed);
      int nextY = this.gridY + (r.nextBoolean() ? 1 : -1) * r.nextInt(this.LandSpeed);
      if(this.canEnter(nextX, nextY, map)){
         this.gridX = nextX;
         this.gridY = nextY;
      }
      else {
         this.gridY += (r.nextBoolean() ? 1 : -1);
         this.gridY = Math.max(0, Math.min(map[0].length - 1, this.gridY));
      }
   }
}