package test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    private static ThreadTest instance;
    private ThreadPoolExecutor executor;


    /**
     * 禁止通过new创建实例
     */
    private ThreadTest() {
    }

    public static ThreadTest getInstance(){
        if (instance==null){
            instance=new ThreadTest();
        }
        return instance;
    }

    public ThreadPoolExecutor getThreadPoolExexutor() {
        if (executor == null) {
            ThreadFactory factory=new ThreadFactoryBuilder()
                    .setNameFormat("Thread-pool-%d")
                    .build();
            executor = new ThreadPoolExecutor(4, 20,
                    2000, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<Runnable>()
                    ,factory,new ThreadPoolExecutor.AbortPolicy());
        }
        return executor;
    }

    public static void main(String[] args) {
        final Logger logger= LoggerFactory.getLogger(ThreadTest.class);
        ThreadPoolExecutor executor = ThreadTest.getInstance().getThreadPoolExexutor();
        Runnable runnable=new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                logger.error(Thread.currentThread().getName());
            }
        };
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);

        executor.shutdown();

    }
}
