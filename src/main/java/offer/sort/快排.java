package offer.sort;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/5 15:07
 */
public class 快排 {
    public static void main(String[] args) {
        快排 test = new 快排();
        int[] a = new int[]{1, 4, 5, 6, 2, 7, 8, 67, 9, 44};
        test.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
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


    /**
     * 快速排序
     *
     * @param arr
     * @param L   指向数组第一个元素
     * @param R   指向数组最后一个元素
     */
    public static void quickSort(int[] arr, int L, int R) {
        int i = L;
        int j = R;

        //支点
        int mid = arr[(L + R) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {

            //寻找直到比支点大的数
            while (mid > arr[i]) {
                i++;
            }

            //寻找直到比支点小的数
            while (mid < arr[j]) {
                j--;
            }

            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。


        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (L < j) {
            quickSort(arr, L, j);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < R) {
            quickSort(arr, i, R);
        }
    }

}
