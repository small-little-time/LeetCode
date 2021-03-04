package offer.easy;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/17 16:27
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        dfs(list, head);
        int[] a = new int[list.size()];
        AtomicInteger b = new AtomicInteger();
        list.forEach(item -> {
            a[b.get()] = item;
            b.incrementAndGet();
        });
        return a;
    }

    private void dfs(List list, ListNode head) {
        if (head == null) {
            return;
        }
        list.add(head.val);
        dfs(list, head.next);
    }
}
