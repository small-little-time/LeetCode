package medium;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/3 14:21
 */
public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

        System.out.println(lowestCommonAncestor(node3, node4, node8).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;

    }

}
