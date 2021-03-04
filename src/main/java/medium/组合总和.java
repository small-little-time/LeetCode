package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/28 23:33
 */
public class 组合总和 {

    public static void main(String[] args) {
        组合总和 test = new 组合总和();
        System.out.println(test.combinationSum(new int[]{1, 2, 3}, 7));
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> oneRes = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(target, 0, candidates);
        return res;
    }

    private void dfs(int target, int idx, int[] candidates) {
        if (idx == candidates.length) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(oneRes));
            return;
        }
        dfs(target, idx + 1, candidates);
        if (target - candidates[idx] >= 0) {
            oneRes.add(candidates[idx]);
            dfs(target - candidates[idx], idx, candidates);
            oneRes.remove(oneRes.size() - 1);
        }

    }

}
