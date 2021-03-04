package common;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/3 14:22
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }


    public static TreeNode nodeCreate(int min, int max, int level, int N) {
        if (min > max || level > N) {
            return null;
        }
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        TreeNode node = new TreeNode(s);
        node.left = nodeCreate(min, s - 1, level + 1, N);
        node.right = nodeCreate(s + 1, max, level + 1, N);
        return node;
    }


    public static List<Integer> traversal(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        subsequentTraversal(node, res);
        return res;
    }

    public static void subsequentTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        subsequentTraversal(node.left, list);
        subsequentTraversal(node.right, list);
    }
}