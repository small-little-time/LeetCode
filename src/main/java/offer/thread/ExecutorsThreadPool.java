package offer.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/8 16:12
 */
public class ExecutorsThreadPool {


    /**
     * execute无返回值，submit返回future
     */
    public static void main(String[] args) {
    }

    private static void cachedThreadPool() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(
                () -> {
                    // ... do something inside runnable task

                });
        service.shutdown();
    }

    private static void singleThreadExecutor() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(
                () -> {
                    // ... do something inside runnable task

                });
        service.shutdown();
    }

    private static void fixedThreadPoll(Runnable runnable) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(
                runnable  // ()->{}
        );
        service.shutdown();
    }


}
