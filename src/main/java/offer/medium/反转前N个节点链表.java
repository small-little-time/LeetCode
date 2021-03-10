package offer.medium;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/3/6 16:29
 */
public class 反转前N个节点链表 {
    public static void main(String[] args) {
        反转前N个节点链表 test = new 反转前N个节点链表();

        ListNode.printLinkedList(test.reverse(ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 3));
    }

    ListNode successor = null;

    ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }

}
