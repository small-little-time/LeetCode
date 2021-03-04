package offer.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/22 16:34
 */
public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        二叉树中和为某一值的路径 test = new 二叉树中和为某一值的路径();
        System.out.println(test.pathSum(TreeNode.arrayToTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22));
    }

    List<List<Integer>> res = new ArrayList<>();
    int m;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        this.m = sum;
        List<Integer> oneRes = new ArrayList<>();
        dfs(root, 0, oneRes);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> oneRes) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;
        oneRes.add(root.val);
        if (sum == m && root.left == null && root.right == null) {
            res.add(new LinkedList(oneRes));
        }

        dfs(root.left, sum, oneRes);
        dfs(root.right, sum, oneRes);
        oneRes.remove(oneRes.size() - 1);
    }
}
/**
 * private void dfs(TreeNode root, int sum, List<Integer> oneRes) {
 * if (root == null) {
 * return;
 * }
 * sum = sum + root.val;
 * oneRes.add(root.val);
 * if (sum == m && root.left == null && root.right == null) {
 * res.add(new LinkedList(oneRes));
 * }
 * <p>
 * dfs(root.left, sum, oneRes);
 * dfs(root.right, sum, oneRes);
 * oneRes.remove(oneRes.size() - 1);
 * }
 */