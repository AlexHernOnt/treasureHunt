import java.util.Scanner;

/*
**  This class takes the player's input and manages it.
*/

public class GameManager {
    private IslandMap map;
    private Scanner scanner;
    private Player player;
    private tmlPrint tml;

    private int counter;

    GameManager(IslandMap map) {
        this.map = map;
        player = new Player(map);
        scanner = new Scanner(System.in);
        tml = new tmlPrint(map);
        startUI();
    }

    // Welcome screen with option of exti
    private void startUI() {
        String strRead;

        tml.cleanScreen();
        map.clean();
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

    // ask to the player to move to a position or dig
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


    // check if the position of the player is the same as the treasure
    private void dig() {
        String strRead;
        boolean won;

        counter++;
        tml.cleanScreen();
        if (map.isTreasureHere(player.getPosY(), player.getPosX())) {
            System.out.println("You found the treasure, you are rich! Next treasure awaits! \n- Ok");
            won = true;
        } else {
            map.dig(player.getPosY(), player.getPosX());
            System.out.println("Nothing here, keep going! \n- Ok");
            won = false;
        }

        strRead = scanner.nextLine();
        if (strRead.equalsIgnoreCase("ok")) {
            if (won) {
                counter = 0;
                startUI();
            } else
                move();
        } else {
            System.out.println("Invalid input: \n'Start'\n'Exit'.");
            dig();
        }

    }
}