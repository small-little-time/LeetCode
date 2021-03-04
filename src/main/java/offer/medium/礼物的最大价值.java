package offer.medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/23 16:22
 */
public class 礼物的最大价值 {
    public static void main(String[] args) {
        礼物的最大价值 test = new 礼物的最大价值();
//        System.out.println(test.maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(test.maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}}));
    }

    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
