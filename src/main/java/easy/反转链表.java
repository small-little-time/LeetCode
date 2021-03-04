package easy;

import common.ListNode;


/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/28 14:13
 */
public class 反转链表 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.createLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode.printLinkedList(listNode);
        ListNode.printLinkedList(reverseList(listNode));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode now = head;
        while (now != null) {
            ListNode nextTemp = now.next;
            now.next = prev;
            prev = now;
            now = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;

    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }



    /*
    *
  reverseList: head=1
    reverseList: head=2
	    reverseList: head=3
		    reverseList:head=4
			    reverseList:head=5
					终止返回
				cur = 5
				4.next.next->4，即5->4   ：5.next = 4
			cur=5
			3.next.next->3，即4->3
		cur = 5
		2.next.next->2，即3->2
	cur = 5
	1.next.next->1，即2->1

	最后返回cur*/
}
