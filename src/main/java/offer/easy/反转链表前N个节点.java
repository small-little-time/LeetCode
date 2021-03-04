package offer.easy;


import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/28 12:55
 */
public class 反转链表前N个节点 {
    public static void main(String[] args) {
        反转链表前N个节点 test = new 反转链表前N个节点();
        ListNode listNode = test.reverseN(ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 4);
        ListNode.printLinkedList(listNode);
    }

    ListNode successor = null;

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
