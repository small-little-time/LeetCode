package easy;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/3 14:58
 */
public class 二叉树的最小深度 {

    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return m1 + m2 + 1;
        }
        return Math.min(m1, m2) + 1;
    }
}
