package Nalog;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Shop shop = new Shop();

        Thread thread1 = new Thread(null, () -> shop.addGain(shop.result), "Магазин 1");
        Thread thread2 = new Thread(null, () -> shop.addGain(shop.result), "Магазин 2");
        Thread thread3 = new Thread(null, () -> shop.addGain(shop.result), "Магазин 3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread3.join();
        thread2.join();
        thread1.join();
        System.out.println("\nБаланс после всех переводов: " + shop.getCuurent());
    }

}
