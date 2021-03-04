package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/4 17:55
 */
public class 子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, nums, list, index + 1);
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1);

        list.remove(list.size() - 1);
    }

}
