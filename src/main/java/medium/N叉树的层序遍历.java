package medium;

import common.Node;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/5 21:23
 */
public class N叉树的层序遍历 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        Deque<Node> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.pop();
                oneRes.add(node.val);
                queue.addAll(node.children);
            }
            res.add(oneRes);
        }
        return res;
    }

}
