package difficult;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/29 16:22
 */
public class 接雨水 {

    public static void main(String[] args) {
        接雨水 test = new 接雨水();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int lMax = 0, rMax = 0;
            for (int j = i; j < n; j++) {
                rMax = Math.max(rMax, height[j]);
            }
            for (int j = i; j >= 0; j--) {
                lMax = Math.max(lMax, height[j]);
            }
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }

}
