import java.util.Random;
import java.util.Scanner;

public class MineSweeperV2 {

    // kullancağım değerleri ve string veya int ile tanımla
    // map arka plandaki haritam , board oyuncunun gördüğü.
    String[][] map;
    String[][] board;
    int rowNumber, colNumber, boardSize, mineCounter = 0;


    //
    public MineSweeperV2(int rowNumber, int colNumber) {
        this.map = new String[rowNumber][colNumber];
        this.board = new String[rowNumber][colNumber];
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.boardSize = rowNumber * colNumber;
    }


    // scanner ve randomu tanımla
    Random random = new Random();
    Scanner input = new Scanner(System.in);


    // oyunu başlat , haritayı yazdır ve mayına basana kadar koordinat ise
    // eğer yanlış değer girilirse hata yazdır.
    public void playGame() {
        int goRow, goCol, winCounteR = 0;
        prepareGame();
        createMap(map);
        System.out.println("===============================");
        System.out.println("           OYUN BAŞLADI        ");
        System.out.println("===============================");
        createMap(board);


        //oyun sırasında hataya veya mayına denk gelmeyene kadar oyunu döndür
        while (true) {
            while (true) {
                System.out.print("Açmak istediğiniz kordinatın Row(satır) değerini giriniz : ");
                if (input.hasNextInt()) {
                    goRow = input.nextInt();
                    if (goRow < 0 || goRow > rowNumber - 1) {
                        System.out.println("alan dışı değer");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Sayısal olmayan değer giriniz");
                    input.next();
                }
            }


            while (true) {
                System.out.print("Açmak istediğiniz koordinatın Col(sütun) değerini giriniz : ");
                if (input.hasNextInt()) {
                    goCol = input.nextInt();
                    System.out.println("----------------------------------------------------");
                    if (goCol < 0 || goCol > colNumber - 1) {
                        System.out.println("Alan dışı değer girdiniz .");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Sayısal olmayan değer girdiniz . ");
                    input.next();
                }
            }


            if (!board[goRow][goCol].equals("-")) {
                System.out.println("Aynı koordinatı denediniz. Başka değer giriniz .");
                continue;
            }

            if (map[goRow][goCol].equals("*")) {
                System.out.println("Game Over !");
                break;
            } else {
                checkMine(goRow, goCol);
                createNew(goRow, goCol);
                mineCounter = 0;
                System.out.println("NICE CHOICE");
                winCounteR++;
                if(winCounteR == boardSize - (boardSize * 25 / 100)){
                    System.out.println("Tebrikler.. Oyunu kazandınız .");
                    break;
                }

            }
        }

    }

    // girilen col ve row değerleri kadar harita oluştur ve her bloğa - yazdır.
    public void createMap(String[][] array) {
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


    // tahtanın boyutunun çeyreği kadar mayın oluştur ve rastgele dağıt
    public void prepareGame() {
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


    //
    public void createNew(int goRow, int goCol) {
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


    // Seçilen koordinatın etrafındaki blokları kontrol et ve mayın sayısı kadar seçilen mayını yazdır.
    public void checkMine(int rowControl, int colControl) {
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

