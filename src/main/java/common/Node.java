package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/6 12:08
 */
public class Node {
    public int val;
    public List<Node> children;
    public Node left;
    public Node right;
    public Node next;


    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node arrayToNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        Node root = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            Node node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new Node(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new Node(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
}
