package Nalog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        LongAdder gain = new LongAdder();

        Shop shop1 = new Shop(gain);
        Shop shop2 = new Shop(gain);
        Shop shop3 = new Shop(gain);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        executorService.submit(shop1::addGain);
        executorService.submit(shop2::addGain);
        executorService.submit(shop3::addGain);

        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Итоговая сумма, руб.: " + gain.sum());
        executorService.shutdown();
    }

}
