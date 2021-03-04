package medium;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/28 20:04
 */
public class 旋转数组 {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < a.length; i++) {
            int t = (i + k) % a.length;
            a[t] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        System.out.println(Arrays.toString(nums));

    }

    public static void rotate2(int[] nums, int k) {
        if (k == 0 || k == nums.length) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }


}
