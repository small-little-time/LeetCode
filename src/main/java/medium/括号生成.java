package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/2 16:29
 */
public class 括号生成 {

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        System.out.println(res);
        return res;
    }

    private static void generate(int left, int right, int n, String s, List<String> res) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(", res);
        }
        if (right < left && right < n) {
            generate(left, right + 1, n, s + ")", res);
        }

    }

}
