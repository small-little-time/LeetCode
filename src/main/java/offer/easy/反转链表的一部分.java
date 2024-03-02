package offer.easy;

import common.ListNode;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/28 13:06
 */
public class 反转链表的一部分 {
    public static void main(String[] args) {
        反转链表的一部分 test = new 反转链表的一部分();
        ListNode listNode = test.reverseBetween2(common.ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5, 6}), 2, 4);
        common.ListNode.printLinkedList(listNode);
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

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode fake = p;
        //先找到前缀节点，也就是要开始翻转的最前的那个节点
        for(int i=0;i<left-1;i++){
            fake = fake.next;
        }
        ListNode pre = null;
        //要开始翻转的链表头
        ListNode cur = fake.next;
        //cur要到翻转结束后的那个节点
        for(int i=0;i<right-left+1;i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        fake.next.next = cur;
        fake.next = pre;
        return p.next;

    }
}
