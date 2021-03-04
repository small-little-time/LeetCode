package offer.easy;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/20 17:26
 */
public class 对称的二叉树 {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}
