package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/16 16:20
 */
//障碍物版本
public class 不同路径II {
    public static void main(String[] args) {
        uniquePathsWithObstacles(new int[][]{{0}});
        uniquePathsWithObstacles(new int[][]{{0, 0}});
        uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 0}});
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[n - 1][m - 1]);
        return dp[n - 1][m - 1];
    }
}
