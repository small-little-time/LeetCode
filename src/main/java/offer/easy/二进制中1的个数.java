package offer.easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/19 15:17
 */
public class 二进制中1的个数 {
    public static void main(String[] args) {
        hammingWeight(00000000000000000000000000001011);
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 10;
        }
        return count;
    }
}
