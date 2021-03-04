package difficult;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/2 11:53
 */
public class 滑动窗口最大值 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow4(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow4(new int[]{1, -1}, 1)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9,11}, 2)));
//        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4,-2}, 2)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;


    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;

    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        //边界条件的判断
        if (nums == null || k <= 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        //双端队列，就是两边都可以插入和删除数据的队列，注意这里存储
        //的是元素在数组中的下标，不是元素的值
        Deque<Integer> qeque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //如果队列中队头元素和当前元素位置相差i-k，相当于队头元素要
            //出窗口了，就把队头元素给移除，注意队列中存储
            //的是元素的下标（函数peekFirst()表示的是获取队头的下标，函数
            //pollFirst()表示的是移除队头元素的下标）
            if (!qeque.isEmpty() && qeque.peekFirst() <= i - k) {
                qeque.pollFirst();
            }
            //在添加一个值之前，前面比他小的都要被移除掉，并且还要保证窗口
            //中队列头部元素永远是队列中最大的
            while (!qeque.isEmpty() && nums[qeque.peekLast()] < nums[i]) {
                qeque.pollLast();
            }
            //当前元素的下标加入到队列的尾部
            qeque.addLast(i);
            //当窗口的长度大于等于k个的时候才开始计算（注意这里的i是从0开始的）
            if (i >= k - 1) {
                //队头元素是队列中最大的，把队列头部的元素加入到数组中
                res[index++] = nums[qeque.peekFirst()];
            }
        }
        return res;

    }

    public static int[] maxSlidingWindow4(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.add(i);
            if (i >= k - 1) {
                res[index] = nums[queue.peekFirst()];
                index++;
            }
        }
        return res;
    }
}