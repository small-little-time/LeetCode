package offer.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/24 21:49
 */
public class 滑动窗口 {
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
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
