package offer.medium;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/20 15:46
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }
        return dfs(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    public boolean dfs(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return dfs(a.left, b.left) && dfs(a.right, b.right);

    }


 /*   public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        //先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
        //只要有一个为true，就说明B是A的子结构
        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean isSub(TreeNode A, TreeNode B) {
        //这里如果B为空，说明B已经访问完了，确定是A的子结构
        if (B == null) {
            return true;
        }
        //如果B不为空A为空，或者这两个节点值不同，说明B树不是
        //A的子结构，直接返回false
        if (A == null || A.val != B.val) {
            return false;
        }
        //当前节点比较完之后还要继续判断左右子节点
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }*/

}
