package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/3/6 15:07
 */
public class 数组中的第K个最大元素 {
    public static void main(String[] args) {

        数组中的第K个最大元素 test = new 数组中的第K个最大元素();
        System.out.println(test.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(test.findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(test.findKthLargest3(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public int findKthLargest3(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }


    public void sort(int[] nums, int L, int R) {
        int i = L;
        int j = R;
        int mid = (i + j) / 2;
        while (i <= j) {
            while (nums[i] < nums[mid]) {
                i++;
            }
            while (nums[j] > nums[mid]) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (i < R) {
            sort(nums, i, R);
        }
        if (j > L) {
            sort(nums, L, j);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
