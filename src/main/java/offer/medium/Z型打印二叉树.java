package offer.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/21 20:10
 */
public class Z型打印二叉树 {
    public static void main(String[] args) {
        Z型打印二叉树 test = new Z型打印二叉树();
        test.levelOrder(TreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}));
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
}
