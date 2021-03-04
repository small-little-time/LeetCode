package easy;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/28 12:24
 */
public class 寻找数组的中心索引 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
        System.out.println(pivotIndex(new int[]{-1, -1, -1, 0, 1, 1}));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length <= 1) {
            return nums.length - 1;
        }
        int sum = Arrays.stream(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left == sum - left - nums[i]) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }
}
