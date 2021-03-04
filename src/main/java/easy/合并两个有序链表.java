package easy;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/28 20:43
 */
public class 合并两个有序链表 {


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.createLinkedList(new int[]{1, 2, 6, 9, 11});
        ListNode listNode2 = ListNode.createLinkedList(new int[]{2, 4, 5, 7, 10});
        ListNode.printLinkedList(mergeTwoLists(listNode1, listNode2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;

    }


}
