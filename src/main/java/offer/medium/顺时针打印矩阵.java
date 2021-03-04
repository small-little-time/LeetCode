package offer.medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/20 18:10
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {

    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[l][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }

        return res;
    }
}
