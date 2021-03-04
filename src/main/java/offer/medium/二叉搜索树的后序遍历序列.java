package offer.medium;

import java.util.Stack;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/21 21:09
 */
public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        二叉搜索树的后序遍历序列 test = new 二叉搜索树的后序遍历序列();
        test.verifyPostorder2(new int[]{1, 3, 2, 6, 5});
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int leftIdx, int rightIdx) {
        if (leftIdx >= rightIdx) {
            return true;
        }
        int p = leftIdx;
        while (postorder[p] < postorder[rightIdx]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[rightIdx]) {
            p++;
        }
        return p == rightIdx && dfs(postorder, leftIdx, m - 1) && dfs(postorder, m, rightIdx - 1);
    }


    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

}
