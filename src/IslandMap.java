import java.util.Random;

/**
 * This class handles the map with a 2D array, with a treausre in a coordinate
 */

public class IslandMap {
    int[][] map;
    int[] treasureCoordinates = {0,0};

    int sizeX;
    int sizeY;

    IslandMap(int x, int y) {
        sizeX = x;
        sizeY = y;

        map = new int[y][];
        for (int i = 0; i < y;i++) {
            map[i] = new int[x];
        }
        generateTreasure();
    }

    private void generateTreasure() {
        Random rand = new Random();

        treasureCoordinates[0] = rand.nextInt(sizeX);
        treasureCoordinates[1] = rand.nextInt(sizeY);
    }
}
