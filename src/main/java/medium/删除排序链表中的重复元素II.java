package medium;

import common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/6 22:12
 */
public class 删除排序链表中的重复元素II {
    public static void main(String[] args) {
//        ListNode linkedList = ListNode.createLinkedList(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode linkedList = ListNode.createLinkedList(new int[]{1, 2, 2});
        删除排序链表中的重复元素II test = new 删除排序链表中的重复元素II();
        ListNode res = test.deleteDuplicates(linkedList);
        ListNode.printLinkedList(res);
    }
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode cur = head;
        while(cur != null){
            int count = map.getOrDefault(cur.val,0);
            map.put(cur.val,++count);
            cur = cur.next;
        }
        while(head != null && havaSameVal(map,head.val)){
            head = head.next;
        }
        if(head == null || head.next == null){
            return head;
        }
        cur = head;
        while(cur.next != null && cur.next.next != null){
            if (havaSameVal(map,cur.next.val)){
                cur.next = findNotSame(cur.next,map);
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    private ListNode findNotSame(ListNode head, Map<Integer,Integer> map){
        while(head != null && havaSameVal(map,head.val)){
            head = head.next;
        }
        return head;
    }

    private boolean havaSameVal(Map<Integer,Integer> map, int val){
        return map.get(val) != null && map.get(val) > 1;
    }
}
