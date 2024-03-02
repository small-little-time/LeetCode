package difficult;

import common.ListNode;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2022/10/19 21:23
 */
public class 合并K个升序链表 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {

            res = mergeTwoLists(res, lists[i]);
        }
        return res;

    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;

    }



    public ListNode mergeTwo(ListNode a,ListNode b){
        ListNode fake = new ListNode(-99);
        ListNode cur = fake;
        while(a != null && b != null){
            if(a.val <= b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
        }
        cur.next = a== null? b : a;
        return fake.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = l + (r-l)/2;
        return mergeTwo(merge(lists,l,mid),merge(lists,mid+1,r));
    }

}
