package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/21 17:06
 */
public class 全排列 {
    public static void main(String[] args) {
        全排列 test = new 全排列();
        System.out.println(test.permute(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> oneRes = new ArrayList<>();
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        for (int num : nums) {
            oneRes.add(num);
        }
        this.n = nums.length;
        bfs(0);
        return res;
    }

    private void bfs(int length) {
        if (length == n) {
            res.add(new ArrayList<>(oneRes));
            return;
        }
        for (int i = length; i < n; i++) {
            Collections.swap(oneRes, length, i);
            bfs(length + 1);
            Collections.swap(oneRes, length, i);
        }
    }

}
