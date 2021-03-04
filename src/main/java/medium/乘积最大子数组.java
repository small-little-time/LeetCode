package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/16 18:04
 */
public class 乘积最大子数组 {
    public static void main(String[] args) {
        乘积最大子数组 test = new 乘积最大子数组();
        int[] a = new int[]{-2, 0, -1, -1};
        test.maxProduct(a);
        System.out.println(test.res);
        System.out.println(test.maxProductDp(a));
    }

    int res;

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        res = nums[0];
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int level, int value) {
        if (level >= nums.length - 1) {
            res = Math.max(value, res);
            return;
        }
        res = Math.max(value, res);
        dfs(nums, level + 1, nums[level + 1] * value);
        dfs(nums, level + 1, nums[level + 1]);
    }

    //动态规划
    public int maxProductDp(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];//0为最大值 1为最小值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = dp[0][0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i]);
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }

    public int maxProduct3(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

}