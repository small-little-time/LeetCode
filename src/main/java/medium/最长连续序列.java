package medium;

import java.util.Arrays;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/18 15:13
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        最长连续序列 test = new 最长连续序列();
        System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(test.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(test.longestConsecutive(new int[]{1, 2, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 1;
        int left = 0;
        int ignoreCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ignoreCount++;
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                res = Math.max(res, i - left + 1 - ignoreCount);
            } else {
                left = i;
                ignoreCount = 0;
            }
        }
        return res;
    }
}
