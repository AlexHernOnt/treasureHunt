import java.util.Scanner;

/*
**  This class takes the player's input and manages it.
*/


public class GameManager {
    private IslandMap map;
    private Scanner scanner;
    private Player player;

    GameManager(IslandMap map) {
        this.map = map;
        player = new Player(map);
        scanner = new Scanner(System.in);
        startUI();
    }

    private void startUI() {
        String strRead;

        cleanScreen();
        System.out.println("Welcome to the island, do you want to start the game?\nStart\nExit\n");
        strRead = scanner.nextLine();

        if (strRead.equalsIgnoreCase("Start")) {
            move();
        } else if (strRead.equalsIgnoreCase("leave")) {
            System.out.println("Closing the program. Goodbye!");
            scanner.close();
        } else {
            System.out.println("Invalid input: \n'Start'\n'Exit'.");
            startUI();
        }
    }

    private void move() {
        String strRead;

        cleanScreen();
        System.out.println("You are at (" + (player.getPosX() + 1) + ", " + (player.getPosY() + 1) +
                                ") What will you do?: \nMove: North | West | South | East\nDig");
        strRead = scanner.nextLine();

        if (strRead.equalsIgnoreCase("north")) {
            player.moveNorth();
            move();
        } else if (strRead.equalsIgnoreCase("west")) {
            player.moveWest();
            move();
        } else if (strRead.equalsIgnoreCase("south")) {
            player.moveSouth();
            move();
        } else if (strRead.equalsIgnoreCase("east")) {
            player.moveEast();
            move();
        } else if (strRead.equalsIgnoreCase("dig")) {
            dig();
        } else {
            System.out.println("Invalid input.");
            move();
        }

    }

    private void dig() {

    }

    private void cleanScreen() {
        for (int i = 0; i < 20; ++i) {
            System.out.println();
        }

    }
}