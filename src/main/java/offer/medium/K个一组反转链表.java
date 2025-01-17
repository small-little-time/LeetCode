package offer.medium;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/3/6 17:16
 */
public class K个一组反转链表 {
    public static void main(String[] args) {
        K个一组反转链表 test = new K个一组反转链表();
        ListNode.printLinkedList(test.reverseKGroup(ListNode.createLinkedList(new int[]{1, 2, 3}), 4));
        ListNode.printLinkedList(test.reverseKGroup2(ListNode.createLinkedList(new int[]{1, 2, 3}), 4));
        ListNode.printLinkedList(test.reverseKGroup(ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 4));
        ListNode.printLinkedList(test.reverseKGroup2(ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 4));

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);

        return newHead;
    }

    public ListNode reverseKGroup2(ListNode head, int k){
        ListNode nodeCount = head;
        int count = 0;
        while(nodeCount != null){
            count++;
            nodeCount = nodeCount.next;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode p = fake;
        ListNode pre = null;
        ListNode cur = head;
        while(count >= k){
            count -= k;
            for(int i =0;i<k;i++){
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur =temp;
            }
            ListNode temp = p.next;
            p.next.next = cur;
            p.next = pre;
            p = temp;
        }
        return fake.next;
    }

    public ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        while (cur != b) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



}
