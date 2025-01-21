/*
**  Player class with Coordinate movement.
*/

public class Player {
    int posX;
    int posY;
    IslandMap map;
    static int movesPerWin[];


    Player(IslandMap map) {
        posX = 0;
        posY = 0;
        this.map = map;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    /*
    **    Change the player position
    */

    public void moveNorth() {
        if (posY < map.getSizeMapY() - 1)
            posY++;
    }

    public void moveWest() {
        if (posX > 0)
            posX--;
    }

    public void moveSouth() {
        if (posY > 0)
            posY--;
    }

    public void moveEast() {
        if (posX< map.getSizeMapX() - 1)
            posX++;
    }

    public void recordMoves(int moves) {
        int[] aux = new int[movesPerWin.length + 1];

            for (int i = 0; i < movesPerWin.length; ++i) {
                aux[i] = movesPerWin[i];
            }
            aux[movesPerWin.length] = moves;
            movesPerWin = aux;
    }

    public static int getCUrrentSteps()
    {
        return movesPerWin[movesPerWin.length];
    }
}
