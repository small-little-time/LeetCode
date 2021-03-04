package easy;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/27 18:14
 */
public class 移动零 {

    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 0, 1, 0, 2, 3, 0};
        moveZeroes(a);
    }

    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
            }
            right++;

        }

        System.out.println(Arrays.toString(nums));


    }

    public static void swap() {

    }


}
