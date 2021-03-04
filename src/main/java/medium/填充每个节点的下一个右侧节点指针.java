package medium;

import common.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/29 14:53
 */
public class 填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        connect(Node.arrayToNode(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
