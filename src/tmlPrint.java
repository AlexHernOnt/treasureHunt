/*
** This class handles the biggest printing methods
*/

public class tmlPrint {

    IslandMap map;

    tmlPrint(IslandMap map) {
        this.map = map;
    }

    // Move the text up to make space
    public void cleanScreen() {
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }
    }

    // Write the map in a visual form
    public void printMap() {
        for (int i = map.getSizeMapY() - 1; i >= 0; --i) {
            for (int j = 0; j < map.getSizeMapX(); ++j) {
                if (map.isDigged(i, j))
                    System.out.print("| OOO |");
                else
                    System.out.print("| ___ |");
            }
            System.out.println();
        }
    }
}
