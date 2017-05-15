package cn.com.mx.highconcurrency.ch7;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future=executor.submit(new RealData("a"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println(future.get());
    }
}
