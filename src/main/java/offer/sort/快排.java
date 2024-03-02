package offer.sort;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/5 15:07
 */
public class 快排 {
    public static void main(String[] args) {
        快排 test = new 快排();
        int[] b = new int[]{-1, 2, -8, -10};
//        test.quickSort(b, 0, b.length - 1);
        test.quickSort2(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
    }

    public void quickSort2(int[] nums, int l, int r) {
        int i = l;
        int j = r;
        int mid = nums[(l + r) / 2];
        while (i <= j) {
            while (mid > nums[i]) {
                i++;
            }
            while (mid < nums[j]) {
                j--;
            }
            if (i <= j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }
        }
        if (i < r) {
            quickSort(nums, i, r);
        }
        if (j > l) {
            quickSort(nums, l, j);
        }
    }

    public void sort(int[] nums, int L, int R) {
        int i = L;
        int j = R;
        int mid = (i + j) / 2;
        while (i <= j) {
            //不能这么写，因为nums数组现在在交换，在变，这样会导致中间数一直在变
            while (nums[i] < nums[mid]) {
                i++;
            }
            while (nums[j] > nums[mid]) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (j > L) {
            sort(nums, L, j);
        }
        if (i < R) {
            sort(nums, i, R);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 快速排序
     *
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;

        //支点
        int mid = arr[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            while (mid > arr[i]) {
                i++;
            }
            while (mid < arr[j]) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (L < j) {
            quickSort(arr, L, j);
        }

        if (i < R) {
            quickSort(arr, i, R);
        }
    }

}
