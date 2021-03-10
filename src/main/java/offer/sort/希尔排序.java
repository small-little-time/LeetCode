package offer.sort;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/3/10 12:00
 */
public class 希尔排序 {
    public static void main(String[] args) {
        希尔排序.sort(new int[]{3, 5, 1, 2, 4});
    }

    private static void sort(int[] arrays) {
        //增量每次都/2
        for (int step = arrays.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arrays.length; i++) {

                int j = i;
                int temp = arrays[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arrays[j - step] > temp) {
                    arrays[j] = arrays[j - step];
                    j = j - step;
                }
                arrays[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arrays));

    }

}
