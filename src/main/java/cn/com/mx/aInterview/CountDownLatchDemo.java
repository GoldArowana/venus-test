package cn.com.mx.aInterview;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangchangye on 2017/3/28.
 *
 * @Author wangchangye
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);//3个门闩
        AtomicInteger a = new AtomicInteger(1);
        Worker worker1=new Worker("zhang san", latch,a);//3个线程
        Worker worker2=new Worker("li si", latch,a);
        Worker worker3=new Worker("wang wu ", latch,a);
        worker1.start();//
        worker1.join();
        worker2.start();//
        worker2.join();
        worker3.start();//
        worker3.join();
    }
    static class Worker extends Thread{
        String workerName;
        CountDownLatch latch;
        AtomicInteger a;
        public Worker(String workerName ,CountDownLatch latch, AtomicInteger a ){
            this.workerName=workerName;
            this.latch=latch;
            this.a=a;
        }
        public void run(){
            doWork();

        }

        private void doWork(){
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+ "    " + a.getAndIncrement());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
            }
        }
    }


}
