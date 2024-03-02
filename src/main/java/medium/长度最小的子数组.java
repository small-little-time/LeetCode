package medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/7 14:38
 */
public class 长度最小的子数组 {
    public static void main(String[] args) {
        长度最小的子数组 test = new 长度最小的子数组();
        System.out.println(test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(test.minSubArrayLen2(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(test.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(test.minSubArrayLen2(4, new int[]{1, 4, 4}));
        System.out.println(test.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.minSubArrayLen2(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(test.minSubArrayLen2(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                set.add(1);
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    set.add(j - i + 1);
                }
            }
        }
        List<Integer> collect = set.stream().sorted().collect(Collectors.toList());
        if (collect.isEmpty()) {
            return 0;
        }
        return collect.get(0);
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target && left < right){
                sum-=nums[left];
                res = Math.min(res,right-left+1);
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;

    }
}
