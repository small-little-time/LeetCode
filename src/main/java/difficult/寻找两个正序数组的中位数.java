package difficult;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2022/10/19 20:51
 */
public class 寻找两个正序数组的中位数 {

    public static void main(String[] args) {
        寻找两个正序数组的中位数 test = new 寻找两个正序数组的中位数();
        double medianSortedArrays = test.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5});
        System.out.println(medianSortedArrays);

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int[] nums = new int[size];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        double res = 0.0;
        if (nums.length % 2 == 0) {
            int idx1 = nums.length / 2 - 1;
            int idx2 = nums.length / 2;
            res = (nums[idx1] + nums[idx2]) / 2.0;
        } else {
            int idx = nums.length / 2;
            res = nums[idx];
        }
        return res;
    }


}
