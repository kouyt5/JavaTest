package test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WaitTest {

    public static void main(String[] args){

        final WaitTest waitTest=new WaitTest();

        ThreadFactory factory=new ThreadFactoryBuilder()
                .setNameFormat("Thread-pool-%d")
                .build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 20,
                2000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>()
                ,factory,new ThreadPoolExecutor.AbortPolicy());
        Runnable runnable1=new Runnable() {
            public void run() {
                try {
                    System.out.println("start waitting");
                    synchronized (waitTest) {
                        waitTest.wait(5000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (waitTest){
                    try {
                        System.out.println("thread1 sleeping");
                        Thread.sleep(5*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread1 wake up");
                }
            }
        };
        Runnable runnable2=new Runnable() {
            public void run() {
                synchronized (waitTest){
                    try {
                        System.out.println("thread2 sleeping");
                        Thread.sleep(5*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("thread2 wake up");
                }
            }
        };

        executor.execute(runnable1);
        executor.execute(runnable2);

        synchronized (waitTest){
            System.out.println("wake up");
            waitTest.notify();
        }
        executor.shutdown();

    }
}
