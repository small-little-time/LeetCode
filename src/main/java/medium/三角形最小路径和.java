package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/12 17:17
 */
public class 三角形最小路径和 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : a) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int anInt : ints) {
                integers.add(anInt);
            }
            list.addAll(Collections.singleton(integers));
        }
        minimumTotal3(list);
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];//加1后不用初始化最后一行【0】
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {//dp最后一行等于triangle
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }


    public static int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1]; //加一是直接防止最底层溢出 初始化为0  dp最后一行等于triangle
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];

    }


}
