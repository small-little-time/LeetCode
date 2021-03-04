package offer.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/8 16:36
 */
public class ThreadPool {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService task = new ThreadPoolExecutor(
                2, 5, 1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            AtomicInteger k = new AtomicInteger(0);
            for (int i = 1; i <= 10; i++) {

                task.execute(() -> {
                    System.out.println("顾客" + k.incrementAndGet() + "\t" + "线程" + Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            task.shutdown();
        }
    }

}
