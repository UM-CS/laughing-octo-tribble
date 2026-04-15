import javax.swing.*;
import javax.swing.Timer;

import Creatures.ZogWalker;
import Creatures.Sauropod;
import Creatures.Pleeb;
import Creatures.BlinkBug;
import Creatures.Landstrider;
import Creatures.RoboSwimmer;
import Creatures.ZogFlyers;
import Creatures.Blobster;
import Creatures.Zappies;
import Creatures.ZogSwimmer;

import Definitions.Alien;
import Definitions.CanFly;
import Definitions.CanSwim;
import Definitions.CanTeleport;
import Definitions.CanWalk;
import Definitions.Terrain;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Supplier;

public class AlienWorldSim extends JPanel {
    private final int GRID_COUNT = 50;
    private final int CELL_SIZE = 15;
    private Terrain[][] map = new Terrain[GRID_COUNT][GRID_COUNT];
    private List<Alien> aliens;

    public AlienWorldSim(int n) {
        setBackground(new Color(20, 20, 30));
        generateMap();
        
        // Registry of types
        Random r = new Random();
        List<Supplier<Alien>> types = Arrays.asList(
            () -> new ZogWalker(r.nextInt(5), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new Sauropod(r.nextInt(1), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new Pleeb(r.nextInt(3), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new BlinkBug(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new Landstrider(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new RoboSwimmer(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new ZogFlyers(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new Blobster(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new Zappies(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE),
            () -> new ZogSwimmer(r.nextInt(GRID_COUNT), r.nextInt(GRID_COUNT), CELL_SIZE)
        );

        aliens = new ArrayList<>();
        for(int i=0; i<n; i++) aliens.add(types.get(r.nextInt(types.size())).get());

        new Timer(200, e -> {
            for (Alien alien : aliens){
                if (alien instanceof CanWalk) {
                    ((CanWalk) alien).walk(map);
                }
                
                if (alien instanceof CanSwim) {
                    ((CanSwim) alien).swim(map);
                }

                if (alien instanceof CanFly) {
                    ((CanFly) alien).fly(map);
                }

                if (alien instanceof CanTeleport) {
                    // Teleporting to a random spot on the 100x100 grid
                    ((CanTeleport) alien).teleport(map);
                }
            }
            repaint();
        }).start();
    }

    private void generateMap() {
        for (int x = 0; x < GRID_COUNT; x++) {
            for (int y = 0; y < GRID_COUNT; y++) {
                // Create a normal river (columns 9 and 10)
                if (x == 9 || x == 10z) map[x][y] = Terrain.RIVER;
                // Create a void river (columns 13 and 14)
                else if (x == 13 || x == 14) map[x][y] = Terrain.VOID;
                else map[x][y] = Terrain.GROUND;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < GRID_COUNT; x++) {
            for (int y = 0; y < GRID_COUNT; y++) {
                if (map[x][y] == Terrain.RIVER) g.setColor(new Color(0, 100, 200));
                else if (map[x][y] == Terrain.VOID) g.setColor(new Color(200, 0, 0));
                else g.setColor(new Color(40, 40, 50));
                g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(new Color(60, 60, 80));
                g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
        for (Alien a : aliens) a.draw(g);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("The Great Divide");
        f.add(new AlienWorldSim(200));
        f.pack();
        f.setSize(765, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}