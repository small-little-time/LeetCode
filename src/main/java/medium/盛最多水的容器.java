package medium;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2022/9/21 22:20
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {
        盛最多水的容器 test = new 盛最多水的容器();
        int i = test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        int i2 = test.maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
        System.out.println(i2);
    }


    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int weight = j - i;
                int high = Math.min(height[j], height[i]);
                max = Math.max(weight * high, max);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left]);
                left++;
            } else {
                res = Math.max(res, (right - left) * height[right]);
                right--;
            }
        }
        return res;
    }
}
