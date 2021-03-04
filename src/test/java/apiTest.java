import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/30 16:06
 */
public class apiTest {

    @Test
    public void test1() {
        int heights[] = new int[]{1, 2, 3};
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
    }

    @Test
    public void test2() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }


    }

    @Test
    public void test3() {
        String a = "zhangyi";
        StringBuilder b = new StringBuilder(a);
        StringBuilder replace = b.replace(0, 1, "*");
        System.out.println(replace);
    }

    @Test
    public void test22() {
        HashMap<String, Map<Object, Object>> map = new HashMap<>();
        HashMap<Object, Object> ma1 = new HashMap<>();
        HashMap<Object, Object> ma2 = new HashMap<>();
        ma1.put("id", 1);
        ma2.put("name", "zhangyi");
        map.put("person", ma1);
        map.put("person", ma2);
        System.out.println(map);
    }

    public volatile int a;

    @Test
    public void test222() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                a++;
            }, i + "").start();
        }
        Thread.sleep(5000);
        System.out.println(a);
    }

    @Test
    public void test123123() {
        char a = '\0';
        System.out.println(5 % 2);
        System.out.println(a);
        System.out.println(sum(35) + sum(37));
        System.out.println(Math.pow(2, 3));

    }

    private int sum(int num) {
        int res = 0;
        while (num > 0) {
            int a = num % 10;
            res = res + a;
            num = num / 10;
        }
        return res;
    }


    @Test
    public void testMap() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        AtomicInteger res = new AtomicInteger();
        map.forEach((k, v) -> {
            res.set(k);
        });
        System.out.println(res.get());

    }

    @Test
    public void test12312345() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        System.out.println(integers.subList(0, integers.size()));
        String a = "a  b";
        System.out.println(Arrays.toString(a.split(" ")));
    }

    @Test
    public void testCopy() {
        int[] a = new int[]{1, 2, 3, 4, 0, 0, 0, 0, 0, 0};
        int[] b = new int[]{1, 2, 3, 4, 0, 0, 0, 0, 0, 0};
        System.arraycopy(a, 0, b, 4, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(System.currentTimeMillis() / 1000);
    }

    @Test
    public void threadLocal() {
        ThreadLocal<String> local = new ThreadLocal<>();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                local.set("11");
                local.set("11");
                System.out.println(local.get());
                local.remove();
            }, "" + i).start();
        }
    }


    @Test
    public void scanner() {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        
    }
}
