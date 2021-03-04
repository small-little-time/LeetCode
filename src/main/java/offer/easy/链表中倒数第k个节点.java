package offer.easy;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/19 20:36
 */
public class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        链表中倒数第k个节点 test = new 链表中倒数第k个节点();
        ListNode.printLinkedList(test.getKthFromEnd(ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 7));
    }

    int count;

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode res = getKthFromEnd(head.next, k);
        if (++count == k) {
            return head;
        }
        return res;
    }


}
