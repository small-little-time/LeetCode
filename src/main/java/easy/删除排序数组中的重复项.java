package easy;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/28 15:41
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

    public static int removeDuplicates(int[] nums) {
        int m = 0;
        int n = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[m] != nums[n]) {
                m++;
                nums[m] = nums[n];
            }

            n++;
        }
        System.out.println(Arrays.toString(nums));
        return m + 1;
    }
}
