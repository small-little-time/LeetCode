package medium;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/7 15:34
 */
public class 不同路径 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        uniquePaths(5, 3);
    }

}
