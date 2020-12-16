package Nalog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Shop {

    public void addGain(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
    }

    public void gain(int[] array) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder gain = new LongAdder();
        IntStream.range(0, array.length)
                .forEach(i -> executorService.submit(() -> gain.add(array[i])));
        System.out.println("Магазин " + Thread.currentThread().getName() + " принес " + gain.sum());
        executorService.shutdown();
    }

}
