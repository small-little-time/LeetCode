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
    }

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
