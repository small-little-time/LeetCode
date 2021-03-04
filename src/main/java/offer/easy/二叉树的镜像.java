package offer.easy;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/20 17:27
 */
public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = mirrorTree(root.right);
        TreeNode left = mirrorTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
