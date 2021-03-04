package medium;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/2 20:24
 */
public class 验证二叉搜索树 {


    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }

        return validBST(root.left, minValue, root.val) && validBST(root.right, root.val, maxValue);
    }


}
