package offer.easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/9 13:42
 */
public class 二分查找 {

    public static void main(String[] args) {
        System.out.println(select(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6));
    }

    public static int select(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
