package offer.medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/18 16:11
 */
public class 机器人的运动范围 {
    public static void main(String[] args) {
        机器人的运动范围 test = new 机器人的运动范围();
        System.out.println(test.movingCount(2, 3, 1));
    }

    int m, n, k;
    boolean[][] visit;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visit = new boolean[m][n];
        return dfs(0, 0, 0);
    }

    public int dfs(int i, int j, int sk) {
        if (i >= m || j >= n || sk > k || visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        int newX = dfs(i + 1, j, sum(i + 1) + sum(j));
        int newY = dfs(i, j + 1, sum(i) + sum(j + 1));
        return 1 + newX + newY;
    }

    private int sum(int num) {
        int res = 0;
        while (num > 0) {
            int a = num % 10;
            res += a;
            num = num / 10;
        }
        return res;
    }
}
