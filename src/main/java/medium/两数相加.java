package medium;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/20 14:52
 */
public class 两数相加 {

    public static void main(String[] args) {
        两数相加 test = new 两数相加();
        ListNode listNode = test.addTwoNumbers(ListNode.createLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9}), ListNode.createLinkedList(new int[]{9, 9, 9, 9}));
        ListNode.printLinkedList(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int j = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + j;
            cur.next = new ListNode(sum % 10);
            j = sum > 9 ? 1 : 0;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (j == 1) {
            cur.next = new ListNode(j);
        }
        return pre.next;
    }
}
