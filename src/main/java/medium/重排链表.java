package medium;

import common.ListNode;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/26 17:48
 */
public class 重排链表 {

    public static void main(String[] args) {
        重排链表 test = new 重排链表();
        ListNode listNode = ListNode.createLinkedList(new int[]{1, 2, 3, 4});
        test.reorderList(listNode);
        ListNode.printLinkedList(listNode);
    }

    public void reorderList(ListNode head) {
        if(head == null){
            return ;
        }
        if(head.next == null){
            return ;
        }
        ListNode mid = getMidNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverListNode(l2);
        mergeNode(head,l2);

    }

    private ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverListNode(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    private ListNode mergeNode(ListNode a,ListNode b){
        ListNode fake = new ListNode(1);
        ListNode cur = fake;
        boolean first = true;
        while(a !=null && b !=null){
            if(first){
                cur.next = a;
                a = a.next;
            }else{
                cur.next =b;
                b = b.next;
            }
            cur = cur.next;
            first = !first;
        }
        if(a != null ){
            cur.next = a;
        }else{
            cur.next = b;
        }
        return fake.next;

    }

}
