package offer.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/21 17:55
 */
public class 从上到下打印二叉树 {
    public static void main(String[] args) {
        从上到下打印二叉树 test = new 从上到下打印二叉树();
        test.levelOrder(TreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}));
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        int[] res;
        Queue<TreeNode> queque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queque.offer(root);
        while (!queque.isEmpty()) {
            int size = queque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queque.poll();
                list.add(node.val);
                if (node.left != null) {
                    queque.offer(node.left);
                }
                if (node.right != null) {
                    queque.offer(node.right);
                }
            }
        }
        int size = list.size();
        res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
