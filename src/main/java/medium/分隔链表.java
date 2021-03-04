package medium;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/3 11:06
 */
public class 分隔链表 {

    public static void main(String[] args) {
        ListNode linkedList = ListNode.createLinkedList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode partition = partition(linkedList, 3);
        ListNode.printLinkedList(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(0);
        ListNode resHead = res;
        ListNode max = new ListNode(0);
        ListNode maxHead = max;

        while (head != null) {
            if (head.val < x) {
                res.next = head;
                res = res.next;
            }
            if (head.val >= x) {
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        max.next = null;
        res.next = maxHead.next;
        return resHead.next;
    }

    public static ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;

    }
}
