import java.util.Random;
import java.util.Scanner;

//Selection 5
public class MineSweeperV2 {

    //  Selection 6 - define terms with string and int
    //  The map is visible to the player and the board runs in the background.
    String[][] map;
    String[][] board;
    int rowNumber, colNumber, boardSize, mineCounter = 0;


    ////Selection 5 - constructor creating .
    public MineSweeperV2(int rowNumber, int colNumber) {
        this.map = new String[rowNumber][colNumber];
        this.board = new String[rowNumber][colNumber];
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.boardSize = rowNumber * colNumber;
    }


    // scanner and random define
    Random random = new Random();
    Scanner input = new Scanner(System.in);

// Selection 6-
    // Start the game and write the map ,
    // print wrong  if the user enters the wrong value
    public void playGame() {
        int goRow, goCol, winCounteR = 0;
        prepareGame();
        createMap(map);
        System.out.println("===============================");
        System.out.println("      THE GAME HAS STARTED     ");
        System.out.println("===============================");
        createMap(board);


        // Continue the game until you encounter no bugs or mines during the game.
        while (true) {
            while (true) {
                System.out.print("Enter the coordinate Row value you want to open:");   // // Selection 9
                if (input.hasNextInt()) {
                    goRow = input.nextInt();
                    if (goRow < 0 || goRow > rowNumber - 1) {       // Selection 10
                        System.out.println("YOU ENTERED THE WRONG TERM");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("YOU ENTERED A NON-NUMERIC VALUE ! ");
                    input.next();
                }
            }


            while (true) {
                System.out.print("Enter the coordinate Column value you want to open:");    // Selection 9
                if (input.hasNextInt()) {
                    goCol = input.nextInt();
                    System.out.println("----------------------------------------------------");
                    if (goCol < 0 || goCol > colNumber - 1) {       // Selection 10
                        System.out.println("YOU ENTERED A NON-NUMERIC VALUE ! ");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("YOU ENTERED THE WRONG TERM ! ");
                    input.next();
                }
            }


            if (!board[goRow][goCol].equals("-")) {
                System.out.println("You selected the same coordinate. Enter another value.");
                continue;
            }

            if (map[goRow][goCol].equals("*")) {  // Selection 13
                System.out.println("Game Over !");   // Selection 15
                break;
            } else {
                checkMine(goRow, goCol);
                createNew(goRow, goCol);
                mineCounter = 0;
                System.out.println("GOOD CHOICE");
                winCounteR++;
                if(winCounteR == boardSize - (boardSize * 25 / 100)){   // Selection 14
                    System.out.println("Congratulations .. You win the game !");  // Selection 15
                    break;
                }

            }
        }

    }

    // Create a map as long as the entered col and row values and print "-" in each block.
    public void createMap(String[][] array) {       // Selection 6
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ("*".equals(array[i][j])) {
                    System.out.print(array[i][j] + " ");
                }
                if (!"*".equals(array[i][j])) {
                    array[i][j] = "-";
                    System.out.print(array[i][j] + " ");
                }
            }
            System.out.println();
        }
    }


    // create mines a quarter of the dimension of the board and distribute them randomly
    public void prepareGame() {         // Selection 8
        int rowMine, colMine, mineCount = 0;

        while (mineCount != (boardSize / 4)) {
            rowMine = random.nextInt(rowNumber);
            colMine = random.nextInt(colNumber);

            if (!"*".equals(map[rowMine][colMine])) {
                map[rowMine][colMine] = "*";
                mineCount++;
            }
        }
    }


    // design the layout of the board
    public void createNew(int goRow, int goCol) {       //Selection 11
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(board[goRow][goCol])) {
                    board[goRow][goCol] = String.valueOf(mineCounter);
                    System.out.print(board[goRow][goCol] + " ");
                    continue;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    // Check the blocks around the selected coordinate and write mines on the selected block as many as the number of mines.
    public void checkMine(int rowControl, int colControl) {     // Selection 12
        if (map[rowControl][colControl].equals("-")) {
            if ((colControl < (colNumber - 1)) && (map[rowControl][colControl + 1]).equals("*")) {
                mineCounter++;
            }
            if (rowControl < (rowNumber - 1) && (map[rowControl + 1][colControl].equals("*"))) {
                mineCounter++;
            }
            if ((colControl > 0) && (map[rowControl][colControl - 1].equals("*"))) {
                mineCounter++;
            }
            if ((rowControl > 0) && (map[rowControl - 1][colControl].equals("*"))) {
                mineCounter++;
            }
            if ((rowControl > 0) && (colControl < (colNumber - 1)) && (map[rowControl - 1][colControl + 1].equals("*"))) {
                mineCounter++;
            }
            if ((colControl > 0) && (rowControl > 0) && (map[rowControl - 1][colControl - 1].equals("*"))) {
                mineCounter++;
            }
            if ((colControl > 0) && (rowControl < (rowNumber - 1)) && (map[rowControl + 1][colControl - 1].equals("*"))) {
                mineCounter++;
            }
            if ((rowControl < (rowNumber - 1)) && (colControl < (colNumber - 1)) && (map[rowControl + 1][colControl + 1].equals("*"))) {
                mineCounter++;
            }
            board[rowControl][colControl] = String.valueOf(mineCounter);
        }

    }
}

