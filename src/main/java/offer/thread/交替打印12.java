package offer.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/27 19:52
 */
public class 交替打印12 {
    static Lock lock = new ReentrantLock();
    static Condition condition1 = lock.newCondition();
    static Condition condition2 = lock.newCondition();
    private static int count = 0;
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        doLock();
        Thread.sleep(5000);
        count = 0;
        System.out.println("---------------------------------------");
        syn();
    }

    public static void doLock() {
        new Thread(
                () -> {
                    while (count <= 100) {
                        lock.lock();
                        try {
                            if (count % 2 == 0) {
                                System.out.println(count++);
                                condition2.signal();
                            } else {
                                condition1.await();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }
                },
                "thread1")
                .start();

        new Thread(
                () -> {
                    while (count <= 100) {
                        lock.lock();
                        try {
                            if (count % 2 == 1) {
                                System.out.println(count++);
                                condition1.signal();
                            } else {
                                condition2.await();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            lock.unlock();
                        }
                    }
                },
                "thread2")
                .start();
    }

    public static void syn() {

        new Thread(
                () -> {
                    synchronized (object) {
                        while (count <= 100) {
                            try {
                                if (count % 2 == 1) {
                                    System.out.println(count++);
                                    object.notify();
                                } else {
                                    object.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                "thread1")
                .start();

        new Thread(
                () -> {
                    synchronized (object) {
                        while (count <= 100) {
                            try {
                                if (count % 2 == 0) {
                                    System.out.println(count++);
                                    object.notify();
                                } else {
                                    object.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                "thread2")
                .start();
    }
}
