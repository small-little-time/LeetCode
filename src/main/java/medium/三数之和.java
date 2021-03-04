package medium;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/28 13:29
 */
public class 三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{1, 2, -2, -1}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int c = (-1) * (nums[i] + nums[j]);
                if (map.containsKey(c) && map.get(c) != i && map.get(c) != j) {
                    List<Integer> oneResult = new ArrayList<>();
                    oneResult.add(nums[i]);
                    oneResult.add(nums[j]);
                    oneResult.add(c);
                    oneResult.sort(((n, m) -> n - m));
                    result.add(oneResult);
                }

            }
        }
        return new ArrayList<>(result);
    }
}
