package Nalog;

import java.util.concurrent.atomic.LongAdder;

public class Shop {

    LongAdder gain;

    public Shop(LongAdder gain) {
        this.gain = gain;
    }

    int[] array = new int[10];

    public void addGain() {
        int result = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 100000);
                result += array[i];
            }
            gain.add(result);
            System.out.println("Выручка из магазина " + Thread.currentThread().getName() + " " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
