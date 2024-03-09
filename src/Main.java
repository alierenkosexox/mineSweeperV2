
// Ali Eren KÖSE    09/03/2024 21:48


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        // satır 2 den büyük veya integer deger olma sorgusu
        while (true) {
            System.out.print("Tahtanın boyutu için Row(satır) değeri giriniz : ");
            if (scanner.hasNextInt()) {
                row = scanner.nextInt();
                if (row < 2) {
                    System.out.println("Girdiğiniz değer 2 'den büyük olmalı .");
                    continue;
                }
                break;
            } else {
                System.out.println("ENTER INTEGER VALUE");
                scanner.next();
            }
        }
        // sütun 2 den büyük veya integer deger olma sorgusu
        while (true) {
            System.out.print("Tahtanın boyutu için Col(sütun) değerini giriniz :");
            if (scanner.hasNextInt()) {
                col = scanner.nextInt();
                System.out.println("----------------------------------------------------");
                if (col < 2) {
                    System.out.println("Girdiğiniz değer 2 'den büyük olamlı .");
                    continue;
                }
                break;
            } else {
                System.out.println("ENTER INTEGER VALUE");
                scanner.next();
            }
        }
        // oyunu başlat , row ve col değerlerini entegre et.
        MineSweeperV2 mine = new MineSweeperV2(row, col);
        mine.playGame();


    }


}