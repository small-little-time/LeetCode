package medium;

import common.ListNode;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/7 10:46
 */
public class 排序链表 {

    public static void main(String[] args) {
        ListNode linkedList = ListNode.createLinkedList(new int[]{4, 2, 1, 3});
        排序链表 test = new 排序链表();
        ListNode res = test.sortList(linkedList);
        ListNode.printLinkedList(res);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return quickSort(head, null);
    }



    private ListNode quickSort(ListNode head, ListNode tail) {
        if(head == null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail){
            fast = fast.next;
            slow = slow.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode a = quickSort(head,slow);
        ListNode b = quickSort(slow,tail);
        return mergeListNode(a,b);

    }


    private ListNode mergeListNode(ListNode a, ListNode b) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        } else if (b != null) {
            cur.next = b;
        }
        return head.next;
    }
}
