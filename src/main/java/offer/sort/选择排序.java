package offer.sort;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/5 16:28
 */
public class 选择排序 {

    public static void main(String[] args) {
        选择排序 test = new 选择排序();
        int[] a = new int[]{1, 4, 5, 6, 2, 7, 8, 67, 9, 44};
        test.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] nums) {
        int maxNumIdx;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNumIdx = 0;
            for (int j = 0; j < nums.length - i; j++) {
                maxNumIdx = nums[j] > nums[maxNumIdx] ? j : maxNumIdx;
            }
            swap(nums, maxNumIdx, nums.length - i - 1);
        }


    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
