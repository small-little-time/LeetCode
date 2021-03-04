package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/5 11:28
 */
public class 较大分组的位置 {
    public static void main(String[] args) {
        System.out.println(largeGroupPositions("aaa"));
        System.out.println(largeGroupPositions("abbxxxxzyy"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    List<Integer> oneRes = new ArrayList<>();
                    oneRes.add(i - num + 1);
                    oneRes.add(i);
                    res.add(oneRes);
                }
                num = 1;
            } else {
                num++;
            }
        }
        return res;
    }
}

