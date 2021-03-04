package offer.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/17 17:46
 */
public class 重建二叉树 {
    public static void main(String[] args) {
        重建二叉树 a = new 重建二叉树();
        a.buildTree(new int[]{3, 9, 5, 6, 20, 15, 7}, new int[]{5, 9, 6, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //把前序遍历的值和中序遍历的值放到list中
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return builder(preorderList, inorderList);
    }

    private TreeNode builder(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.isEmpty()) {
            return null;
        }
        //前序遍历的第一个值就是根节点
        int rootVal = preorderList.remove(0);

        //创建跟结点
        TreeNode root = new TreeNode(rootVal);

        // 递归构建左右子树
        // 先找到根节点在中序遍历中的位置，进行划分
        int rootIndex = inorderList.indexOf(rootVal);

        // 构建左子树，范围 [0:rootIndex)
        root.left = builder(preorderList, inorderList.subList(0, rootIndex));

        // 构建右子树，范围 (rootIndex:最后的位置]
        root.right = builder(preorderList, inorderList.subList(rootIndex + 1, inorderList.size()));
        // 返回根节点`
        return root;
    }

}
