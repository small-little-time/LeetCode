package medium;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/30 16:48
 */
public class 链表相加 {
    public static void main(String[] args) {
        链表相加 test = new 链表相加();
        test.addInList(ListNode.createLinkedList(new int[]{9, 3, 7}), ListNode.createLinkedList(new int[]{6, 3}));

    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        Deque<Integer> stack3 = new ArrayDeque<>();
        pushStack(head1, stack1);
        pushStack(head2, stack2);
        ListNode res = new ListNode(0);
        ListNode cur = res;
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int c = a + b + sum;
            stack3.push(c % 10);
            sum = c > 9 ? 1 : 0;
        }
        if (sum == 1) {
            stack3.push(1);
        }
        while (!stack3.isEmpty()) {
            cur.next = new ListNode(stack3.pop());
            cur = cur.next;
        }
        return res.next;

    }

    private void pushStack(ListNode head, Deque<Integer> stack) {
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
    }
}
