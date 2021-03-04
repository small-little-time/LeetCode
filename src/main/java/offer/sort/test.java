package offer.sort;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/7 19:28
 */
public class test {
    public static void main(String[] args) {
        test test = new test();
        int[] a = new int[]{1, 4, 5, 6, 2, 7, 8, 67, 9, 44};
        test.归并(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    private void 快排(int[] nums, int L, int R) {
        int mid = nums[(L + R) / 2];
        int i = L;
        int j = R;
        while (i <= j) {

            while (nums[i] < mid) {
                i++;
            }
            while (nums[j] > mid) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        if (i < R) {
            快排(nums, i, R);
        }
        if (j > L) {
            快排(nums, L, j);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void 归并(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int mid = (L + R) / 2;
        归并(nums, L, mid);
        归并(nums, mid + 1, R);
        merge(nums, L, R, mid);
    }

    private void merge(int[] nums, int l, int r, int mid) {
        int[] leftArray = new int[mid - l];
        int[] rightArray = new int[r - mid + 1];
        for (int i = l; i < mid; i++) {
            leftArray[i - l] = nums[i];
        }
        for (int i = mid; i <= r; i++) {
            rightArray[i - mid] = nums[i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
                k++;
            } else {
                nums[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while (i < leftArray.length) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightArray.length) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
