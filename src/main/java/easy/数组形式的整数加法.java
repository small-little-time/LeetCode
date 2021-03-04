package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/22 15:52
 */
public class 数组形式的整数加法 {

    public static void main(String[] args) {
        数组形式的整数加法 test = new 数组形式的整数加法();
        System.out.println(test.addToArrayForm(new int[]{0}, 34));
        System.out.println(test.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(test.addToArrayForm(new int[]{2, 1, 5}, 806));
    }

    public List<Integer> addToArrayForm(int[] A, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = A.length - 1;
        int sum = 0;
        while (k != 0 || i >= 0) {
            int t = k % 10;
            int a = i >= 0 ? A[i] : 0;
            sum = t + a + sum;
            res.addFirst(sum % 10);
            sum = sum > 9 ? 1 : 0;
            if (k != 0) {
                k = k / 10;
            }
            i--;
        }
        if (sum != 0) {
            res.addFirst(sum);
        }
        return res;
    }
}
