package offer.easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/12 21:41
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray2(new int[]{-2, -1}));
        System.out.println(maxSubArray(new int[]{-2, -1}));
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    public static int maxSubArray2(int[] nums) {

        int res = nums[0];
        int dpRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpRes = Math.max(dpRes, 0) + nums[i];
            res = Math.max(dpRes, res);
        }
        return res;
    }
}
