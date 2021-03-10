package offer.medium;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/3/6 16:42
 */
public class 反转第M到N节点链表 {
    public static void main(String[] args) {
        反转第M到N节点链表 test = new 反转第M到N节点链表();

        ListNode.printLinkedList(test.reverse(ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 2, 4));
    }

    ListNode successor = null;

    public ListNode reverse(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverse(head.next, m - 1, n - 1);
        return head;

    }

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;

    }
}
