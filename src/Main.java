
// Ali Eren KÖSE    09/03/2024 21:48


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        // Query for Row to be greater than 2 or an integer value
        while (true) {
            System.out.print("Enter the Row value for the size of the board : ");       //Selection 7
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                if (row < 2) {
                    System.out.println("The value you enter must be greater than 2. ");
                    continue;
                }
                break;
            } else {
                System.out.println("ENTER INTEGER VALUE");
                scanner.next();
            }
        }
        // Query for column to be greater than 2 or an integer value
        while (true) {
            System.out.print("Enter the Column value for the size of the board : ");    //Selection 7
            if (scanner.hasNextInt()) {
                col = scanner.nextInt();
                System.out.println("----------------------------------------------------");
                if (col < 2) {
                    System.out.println("The value you enter must be greater than 2. ");
                    continue;
                }
                break;
            } else {
                System.out.println("ENTER INTEGER VALUE");
                scanner.next();
            }
        }
        // start the game, integrate row and column values.
        MineSweeperV2 mine = new MineSweeperV2(row, col);
        mine.playGame();


    }


}