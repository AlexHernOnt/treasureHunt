import java.util.Random;

/*
** This class handles the map with a 2D array, with a treausre in a coordinate
*/

public class IslandMap {
    private int[][] map;
    private int[] treasureCoordinates = {0,0};

    private int sizeX;
    private int sizeY;

    IslandMap(int x, int y) {
        sizeX = x;
        sizeY = y;

        map = new int[y][];
        for (int i = 0; i < y; i++) {
            map[i] = new int[x];
        }
        generateTreasure();
    }

    private void generateTreasure() {
        Random rand = new Random();

        treasureCoordinates[0] = rand.nextInt(sizeX);
        treasureCoordinates[1] = rand.nextInt(sizeY);
    }

    public boolean isTreasureHere(int y, int x) {

        if (treasureCoordinates[0] == y && treasureCoordinates[1] == x)
            return true;
        else
            return false;
    }

    public void dig(int y, int x) {
        map[y][x] = 1;
    }

    public int getSizeMapY() {
        return (map.length);
    }

    public int getSizeMapX() {
        return (map[0].length);
    }

    public boolean isDigged(int i, int j) {
        return map[i][j] == 1;
    }
}
