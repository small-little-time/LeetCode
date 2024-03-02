package offer.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/27 16:10
 */
public class 交替打印ABC {

    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static String str = "A";
    private final static  Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();

        Thread.sleep(1000*100);
    }

    private static void test1() {
        CompletableFuture.runAsync(() -> {
            while (true) {
                try {
                    lock.lock();
                    if ("A".equals(str)) {
                        System.out.println(str);
                        Thread.sleep(1000);
                        str = "B";
                        conditionB.signal();
                    } else {
                        conditionA.await();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        CompletableFuture.runAsync(() -> {
            while (true) {
                try {
                    lock.lock();
                    if ("B".equals(str)) {
                        System.out.println(str);
                        Thread.sleep(1000);
                        str = "C";
                        conditionC.signal();
                    } else {
                        conditionB.await();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        CompletableFuture.runAsync(() -> {
            while (true) {
                try {
                    lock.lock();
                    if ("C".equals(str)) {
                        System.out.println(str);
                        System.out.println("----------------");
                        Thread.sleep(1000);
                        str = "A";
                        conditionA.signal();
                    } else {
                        conditionC.await();
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
    }

    private static void test2(){
        CompletableFuture.runAsync(() -> {
            while (true) {
                try {
                    synchronized (object){
                    if ("A".equals(str)) {
                        System.out.println(str);
                        Thread.sleep(1000);
                        str = "B";
                        object.notifyAll();
                    } else {
                        object.wait();
                    }
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        CompletableFuture.runAsync(() -> {
            while (true) {
                try {
                    synchronized (object){
                        if ("B".equals(str)) {
                            System.out.println(str);
                            Thread.sleep(1000);
                            str = "C";
                            object.notifyAll();
                        } else {
                            object.wait();
                        }
                    }


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        CompletableFuture.runAsync(() -> {
            while (true) {
                try {
                   synchronized (object){
                       if ("C".equals(str)) {
                           System.out.println(str);
                           System.out.println("----------------");
                           Thread.sleep(1000);
                           str = "A";
                           object.notifyAll();
                       } else {
                           object.wait();
                       }
                   }


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}
