package offer.other;

import java.util.Scanner;

public class Main {
    static char[] inputs;

    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(j) == s.charAt(i)) {
                    if (dp[i][j] = i == j || dp[i + 1][j - 1]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

}
