package offer.thread.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/28 22:10
 */
public class LRU<k, v> {

    class ListNode {
        ListNode prev;
        ListNode next;
        k key;
        v value;

        public ListNode(k key, v value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {
        }
    }


    private Map<k, ListNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private ListNode head, tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.prev = head;
    }

    public void addToTop(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    public void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToTop(ListNode node) {
        removeNode(node);
        addToTop(node);
    }

    public ListNode removeTail() {
        ListNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public v get(k key) {
        ListNode node = map.get(key);
        return node == null ? null : node.value;
    }

    public void put(k key, v value) {
        ListNode node = map.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            map.put(key, newNode);
            addToTop(newNode);
            ++size;
            if (size > capacity) {
                ListNode listNode = removeTail();
                map.remove(listNode.key);
                size--;
            }


        } else {
            node.value = value;
            map.put(key, node);
            moveToTop(node);
        }
    }

    public static void main(String[] args) {
        LRU<String, String> lru = new LRU<String, String>(2);
        lru.put("zhangyi", "zhangyi");
        lru.put("leilei", "leilei");
        lru.put("momo", "momo");
        lru.put("leilei", "zzz");
        lru.put("momo", "momo");
        System.out.println(lru);
    }


    @Override
    public String toString() {
        ListNode cur = head.next;
        StringBuilder res = new StringBuilder();
        res.append("{");
        while (cur != tail) {
            res.append(cur.value);
            cur = cur.next;
            if (cur != tail) {
                res.append(",");
            }
        }
        res.append("}");
        return res.toString();
    }


}
