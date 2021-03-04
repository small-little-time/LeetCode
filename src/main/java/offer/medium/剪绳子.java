package offer.medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/19 13:30
 */
public class 剪绳子 {
    public static void main(String[] args) {
        剪绳子 test = new 剪绳子();
        System.out.println(test.cuttingRope(4));
        System.out.println(test.integerBreak(4));
    }

    int[] resCatch;

    public int cuttingRope(int n) {
        this.resCatch = new int[n + 1];
        resCatch[2] = 1;
        return dfs(n);
    }

    private int dfs(int n) {

        if (resCatch[n] != 0) {
            return resCatch[n];
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = Math.max(Math.max(i * dfs(n - i), i * (n - i)), res);
        }
        resCatch[n] = res;
        return res;
    }


    public int cuttingRopeDp(int n) {
        int[] dp = new int[n + 1];
        // 初始状态
        dp[2] = 1;
        // 状态转移方程
        for (int i = 3; i < n + 1; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        // 返回值
        return dp[n];
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

}
