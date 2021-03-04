package easy;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/30 14:10
 */
public class 最后一块石头的重量 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight2(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        List<Integer> linkedList = new LinkedList<>();
        for (int i = stones.length - 1; i >= 0; i--) {
            linkedList.add(stones[i]);
        }
        while (linkedList.size() > 2) {
            int a = linkedList.get(0);
            int b = linkedList.get(1);
            int c = a > b ? a - b : b - a;
            linkedList.remove(0);
            linkedList.remove(0);
            linkedList.add(c);
            linkedList.sort((n, m) -> m - n);
            System.out.println(linkedList);
        }
        return linkedList.get(0) - linkedList.get(1);
    }

    public static int lastStoneWeight2(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 2) {
            int a = queue.poll();
            int b = queue.poll();
            int c = a - b;
            queue.offer(c);
        }

        return queue.poll() - queue.poll();
    }
}
