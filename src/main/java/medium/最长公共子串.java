package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/30 17:50
 */
public class 最长公共子串 {
    public static void main(String[] args) {
        最长公共子串 test = new 最长公共子串();
        System.out.println(test.LCS("1AB2345CD", "12345EF"));
        System.out.println(test.LCS("12345EF", "1AB2345CD"));
    }

    public String LCS(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c1 = str1.charAt(i), c2 = str2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (max < dp[i + 1][j + 1]) {
                        max = dp[i + 1][j + 1];
                        index = i + 1;
                    }
                }
            }
        }
        return max == 0 ? "-1" : str1.substring(index - max, index);
    }


}
