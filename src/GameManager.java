import java.util.Scanner;

/*
**  This class takes the player's input and manages it.
*/

public class GameManager {
    private IslandMap map;
    private Scanner scanner;
    private Player player;
    private tmlPrint tml;

    GameManager(IslandMap map) {
        this.map = map;
        player = new Player(map);
        scanner = new Scanner(System.in);
        tml = new tmlPrint(map);
        startUI();
    }

    private void startUI() {
        String strRead;

        tml.cleanScreen();
        System.out.println("Welcome to the island, do you want to start the game?\nStart\nExit\n");
        strRead = scanner.nextLine();

        if (strRead.equalsIgnoreCase("Start")) {
            move();
        } else if (strRead.equalsIgnoreCase("Exit")) {
            System.out.println("Closing the program. Goodbye!");
            scanner.close();
        } else {
            System.out.println("Invalid input: \n'Start'\n'Exit'.");
            startUI();
        }
    }

    private void move() {
        String strRead;

        tml.cleanScreen();
        System.out.println("You are at (" + (player.getPosX() + 1) + ", " + (player.getPosY() + 1) +
                                ") What will you do?: \nMove: North | West | South | East\nDig");

        tml.printMap();
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
        String strRead;

        tml.cleanScreen();
        if (map.isTreasureHere(player.getPosY(), player.getPosX())) {
            System.out.println("You found the treasure, you are rich! Goodbye!");
        } else {
            map.dig(player.getPosY(), player.getPosX());
            System.out.println("Nothing here, keep going! \n- Ok");
            strRead = scanner.nextLine();
            if (strRead.equalsIgnoreCase("ok")) {
                move();
            } else {
                System.out.println("Invalid input: \n'Start'\n'Exit'.");
                dig();
            }
        }
    }
}