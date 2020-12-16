package Toy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Toggle toggle = new Toggle();

        Thread t1 = new Thread(null, toggle::onSwitch, "Игрок");
        Thread t2 = new Thread(null, toggle::offSwitch, "Игрушка");

        t2.start();
        t1.start();
    }
}
