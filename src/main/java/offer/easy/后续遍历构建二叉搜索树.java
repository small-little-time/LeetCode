package offer.easy;

import common.TreeNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/15 13:02
 */
public class 后续遍历构建二叉搜索树 {
    public static void main(String[] args) {
//        TreeNode build = build(new int[]{2, 4, 6, 8, 7, 5});
        TreeNode build2 = build(new int[]{1, 6, 3, 2, 5});
        System.out.println(build2);
    }

    public static TreeNode build(int[] posArr) {
        return process2(posArr, 0, posArr.length - 1);
    }

    private static TreeNode process(int[] posArr, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return null;
        }
        //后续遍历  rightIdx为头结点
        TreeNode node = new TreeNode(posArr[rightIdx]);
        if (leftIdx == rightIdx) {
            return node;
        }
        int m = leftIdx - 1;
        for (int i = leftIdx; i < rightIdx; i++) {
            if (posArr[i] < posArr[rightIdx]) {
                m = i;
            }
        }
        node.left = process(posArr, leftIdx, m);
        node.right = process(posArr, m + 1, rightIdx - 1);
        return node;
    }

    //二分查找
    private static TreeNode process2(int[] posArr, int leftIdx, int rightIdx) {
        if (leftIdx > rightIdx) {
            return null;
        }
        //后续遍历  rightIdx为头结点
        TreeNode node = new TreeNode(posArr[rightIdx]);
        if (leftIdx == rightIdx) {
            return node;
        }
        int m = leftIdx - 1;
        int left = leftIdx;
        int right = rightIdx - 1;
        while (left <= right) {
            int mid = left + (right - leftIdx) / 2;
            if (posArr[mid] < posArr[rightIdx]) {
                m = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        node.left = process2(posArr, leftIdx, m);
        node.right = process2(posArr, m + 1, rightIdx - 1);
        return node;
    }
}
