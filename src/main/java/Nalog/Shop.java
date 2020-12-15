package Nalog;

import java.util.concurrent.atomic.AtomicLong;

public class Shop {
    AtomicLong gain = new AtomicLong();
    long result = 0;
    long[] array = new long[10];

    public void addGain(long result) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (long) ((Math.random() * 100000));
            result += array[i];
        }
        System.out.println(Thread.currentThread().getName() + " дал выручку " + result);
        long res = gain.addAndGet(result);
        System.out.println("Общая выручка с магазинов " + res);
    }

    public long getCuurent() {
        return gain.get();
    }
}
