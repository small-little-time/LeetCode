package common;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/3 11:08
 */
public class ListNode {
    public int val;
    public ListNode next;


    public ListNode(int x) {
        val = x;
    }

    public static ListNode createLinkedList(int[] arr) {// 将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {// 过程
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {// 将链表结果打印
        ListNode cur = head;
        while (cur != null) {
            System.out.printf("%d -> ", cur.val);
            cur = cur.next;
        }
        System.out.println("NULL");
    }
}
