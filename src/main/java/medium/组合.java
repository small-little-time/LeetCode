package medium;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/4 15:06
 */
public class 组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public static void getCombine(int n, int k, int start, List<Integer> list) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            getCombine(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
