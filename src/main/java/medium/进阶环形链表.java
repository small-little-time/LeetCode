package medium;

import common.ListNode;

import java.util.HashSet;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/29 10:36
 */
public class 进阶环形链表 {


    public static void main(String[] args) {
        ListNode list = ListNode.createLinkedList(new int[]{3, 2, 0, -4});
        System.out.println(list.next.next.next.val);
        System.out.println(list.next.val);
        list.next.next.next.next = list.next;
        System.out.println(list.next.next.next.next.val);

        System.out.println(detectCycle(list).val);
        System.out.println(detectCycle2(list).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
