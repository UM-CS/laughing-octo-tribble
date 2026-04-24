package Definitions;

public interface CanWalk {
    public void walk(Terrain[][] map);
    default public void walk(Terrain[][] map, String soundPath){
        System.out.println("This isn't implemented!");
    }
}
