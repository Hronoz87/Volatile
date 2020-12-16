package Nalog;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Shop shop = new Shop();

        int[] array1 = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];

        shop.addGain(array1);
        shop.addGain(array2);
        shop.addGain(array3);

        Thread t1 = new Thread(null, () -> {
            try {
                shop.gain(array1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1");
        Thread t2 = new Thread(null, () -> {
            try {
                shop.gain(array2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2");
        Thread t3 = new Thread(null, () -> {
            try {
                shop.gain(array3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3");

        t1.start();
        t2.start();
        t3.start();
    }

}
