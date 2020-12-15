package Toy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Toggle toggle = new Toggle();

        Thread t1 = new Thread(null, () -> {
            toggle.setToggle(true);
            toggle.onToggle();

        }, "Игрок");
        Thread t2 = new Thread(null, () -> {
            while (!toggle.isToggle()) {

                toggle.offToggle();
            }
        }, "Игрушка");

        t2.start();
        t1.start();

        t1.join(3000);
        t2.join(3000);

    }
}
