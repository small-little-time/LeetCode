package offer.medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/19 15:31
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        数值的整数次方 test = new 数值的整数次方();
        System.out.println(test.myPow(2, 10));
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

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = quickMul(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
/*      if (n == 0){
        return 1;
    }
    double res = quickMul(x,n/2);
        if ( n%2 == 0){
        return res * res;
    }else {
        return res* res * x;
    }*/
}
