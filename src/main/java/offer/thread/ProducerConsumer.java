package offer.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/8 22:04
 */
public class ProducerConsumer {

    public static void main(String[] args) {

        try {
            MyProducerConsumer my = new MyProducerConsumer(new ArrayBlockingQueue<>(3));
            new Thread(() -> {
                try {
                    my.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "product").start();
            Thread.sleep(1000);
            new Thread(() -> {
                try {
                    my.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "consumer").start();
            Thread.sleep(10000);
            my.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void arrayBlockingQueue() {
        AtomicInteger count = new AtomicInteger(0);
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        new Thread(() -> {
            while (true) {
                try {
                    arrayBlockingQueue.put(count.incrementAndGet());
                    System.out.println("生产:" + count.get());
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "producer").start();


        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("消费:" + arrayBlockingQueue.take());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "consumer").start();

    }
}


class MyProducerConsumer {

    private volatile boolean flag = true;
    private BlockingQueue<Integer> blockingQueue = null;
    private AtomicInteger integer = new AtomicInteger();

    public MyProducerConsumer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void stop() {
        this.flag = false;
    }

    public void product() throws InterruptedException {
        Boolean productRes = null;
        while (flag) {
            productRes = blockingQueue.offer(integer.incrementAndGet(), 2L, TimeUnit.SECONDS);
            if (productRes) {
                System.out.println("生产:" + integer.get());
            } else {
                System.out.println("生产失败");
                integer.decrementAndGet();
            }
//            Thread.sleep(3000);
            Thread.sleep(1000);
        }
    }

    public void consumer() throws InterruptedException {
        Integer res = null;
        while (flag) {
//            Thread.sleep(10000);
            res = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == res) {
                flag = false;
                System.out.println("超过两秒没取到，生产结束");
                return;
            }
            System.out.println("消费:" + res);
        }
    }

}