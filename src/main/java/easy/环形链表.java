package easy;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/28 15:15
 */
public class 环形链表 {
    public static void main(String[] args) {
        ListNode list = ListNode.createLinkedList(new int[]{1, 2, 3});
        System.out.println(hasCycle(list));
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }




}
