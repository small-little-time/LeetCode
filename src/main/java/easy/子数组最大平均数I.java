package easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/4 20:37
 */
public class 子数组最大平均数I {
    public static void main(String[] args) {

    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int n = nums.length;
        int res = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i];
            res = Math.max(sum, res);
        }

        return 1.0 * res / 4;

    }
}
