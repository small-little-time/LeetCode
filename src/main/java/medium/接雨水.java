package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/30 13:46
 */
public class 接雨水 {
    public static void main(String[] args) {
        接雨水 test = new 接雨水();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(test.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int[] lMax = new int[n];
        lMax[0] = height[0];
        int[] rMax = new int[n];
        rMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(rMax[i], lMax[i]) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left != right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
