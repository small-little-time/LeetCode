package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/4 11:30
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.myPow(2.0, 10));
    }

    public double quickMul(double x, int N) {
        if (N == 0) {
            return 1;
        }
        double res = quickMul(x, N / 2);
        if (N % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }

    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return quickMul(x, n);
    }

}
