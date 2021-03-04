package easy;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/6 13:03
 */
public class 分发饼干 {

    public static void main(String[] args) {
        System.out.println(findContentChildren2(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int a = g.length - 1;
        int b = s.length - 1;
        int num = 0;
        while (a >= 0 && b >= 0) {
            if (g[a] <= s[b]) {
                a--;
                b--;
                num++;
            } else {
                a--;
            }
        }
        return num;
    }

    public static int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= g[count]) {
                count++;
                if (count == g.length) {
                    break;
                }
            }
        }
        return count;
    }
}
