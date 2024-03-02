package offer.medium;

import common.TreeNode;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/21 20:10
 */
public class Z型打印二叉树 {
    public static void main(String[] args) {
        Z型打印二叉树 test = new Z型打印二叉树();
//        test.levelOrder(TreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}));
        test.levelOrder2(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3, 4, null, null, 5}));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int flag = res.size();
            LinkedList<Integer> oneRes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag % 2 == 0) {
                    oneRes.add(node.val);
                } else {
                    oneRes.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(oneRes);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> oneRes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (!isLeft) {
                    oneRes.add(node.val);
                }else{
                    oneRes.addFirst(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
            isLeft = !isLeft;
            res.add(oneRes);
        }
        return res;
    }
}
