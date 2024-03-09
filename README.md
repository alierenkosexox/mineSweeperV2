 MineSweeper Oyunu

Bu, klasik MineSweeper oyununun Java dilinde basit bir konsol tabanlı uygulamasıdır.

## Nasıl Oynanır

1. `MineSweeper.java` dosyasını çalıştırın.
2. Oyun tahtası için satır ve sütun sayısını girmeniz istenecektir.
3. Oyun tahtası gösterilecek ve açmak istediğiniz satır ve sütunu girmeniz istenecektir.
4. Eğer bir mayına denk gelirseniz, oyun biter. Aksi halde, komşu mayın sayısı görüntülenecektir.
5. Mayına denk gelmeden tüm hücreleri açana kadar veya bir mayına denk gelene kadar oyunu sürdürün.

## Özellikler

- Oyun tahtasında mayınları rastgele oluşturur.
- Oyuncuların satır ve sütun numaralarını girerek hücreleri açmalarına izin verir.
- Her hücre için komşu mayın sayısını izler.
- Oyuncu bir mayına denk gelirse oyunu sonlandırır.
- Oyuncunun tüm güvenli hücreleri başarıyla açtığında veya bir mayına denk geldiğinde oyunu sonlandırır.

## Kod İncelemesi

- `MineSweeper.java`: Oyun mantığını içeren ana sınıfı içerir.
- Oyun tahtasını ve gizli mayın konumlarını temsil etmek için 2D diziyi kullanır.
- Bir hücre seçildiğinde komşu mayın sayılarını göstermek için iç içe döngüler kullanır.

## Gereksinimler

- Sisteminizde Java Geliştirme Kiti (JDK) yüklü olmalıdır.

## Nasıl Çalıştırılır

`MineSweeper.java` dosyasını derleyin:

```bash
javac MineSweeper.java
