package offer.sort;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/5 17:18
 */
public class 归并 {
    public static void main(String[] args) {
        归并 test = new 归并();
        int[] a = new int[]{1, 4, 5, 6, 2, 7, 8, 67, 9, 44};
        test.mergeSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    public void mergeSort(int[] arrays, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = (L + R) / 2;
        mergeSort(arrays, L, M);
        mergeSort(arrays, M + 1, R);
        mergeArray(arrays, L, M + 1, R);
      
    }


    private void mergeArray(int[] arrays, int L, int mid, int R) {
        int[] leftArray = new int[mid - L];
        int[] rightArray = new int[R - mid + 1];
        for (int i = L; i < mid; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = mid; i <= R; i++) {
            rightArray[i - mid] = arrays[i];
        }
        int i = 0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arrays[k] = leftArray[i];
                k++;
                i++;
            } else {
                arrays[k] = rightArray[j];
                k++;
                j++;
            }
        }
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            k++;
            i++;
        }
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            k++;
            j++;
        }
    }


    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {

        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }


        int i = 0, j = 0;
        // arrays数组的第一个元素
        int k = L;

        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];

                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];

            k++;
            j++;
        }
    }
}
