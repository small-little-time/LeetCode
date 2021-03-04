package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/3/4 14:04
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        打家劫舍 test = new 打家劫舍();
        System.out.println(test.rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
