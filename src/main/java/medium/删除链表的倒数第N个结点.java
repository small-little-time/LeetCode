package medium;

import common.ListNode;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2022/9/21 22:52
 */
public class 删除链表的倒数第N个结点 {

    public static void main(String[] args) {
        删除链表的倒数第N个结点 test = new 删除链表的倒数第N个结点();
//        ListNode listNode = test.removeNthFromEnd2(ListNode.createLinkedList(new int[]{1,2}), 1);
        ListNode listNode2 = test.removeNthFromEnd(ListNode.createLinkedList(new int[]{1}), 1);
//        ListNode.printLinkedList(listNode);
        ListNode.printLinkedList(listNode2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode second = head;
        ListNode first = fake;
        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return fake.next;
    }


}
