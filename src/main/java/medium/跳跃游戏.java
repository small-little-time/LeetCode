package medium;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/6 17:06
 */
public class 跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        return dfs(0, nums);
    }

    private static boolean dfs(int index, int[] nums) {
        if (index >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= nums[index]; i++) {
            if (dfs(i + index, nums)) {
                return true;
            }
        }

        return false;
    }


    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= end) {
                end = i;
            }
        }
        return end == 0;
    }

}
