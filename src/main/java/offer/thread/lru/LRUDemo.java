package offer.thread.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/28 15:22
 */
public class LRUDemo<K, V> {

    class LinkedNode {
        LinkedNode prev;
        LinkedNode next;
        K key;
        V value;

        public LinkedNode() {
        }

        public LinkedNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<K, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    public LRUDemo(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        LinkedNode v = cache.get(key);
        if (v == null) {
            return null;
        }
        return v.value;
    }

    public void put(K key, V value) {
        LinkedNode v = cache.get(key);
        if (v == null) {
            LinkedNode node = new LinkedNode(key, value);
            cache.put(key, node);
            addToTop(node);
            ++size;
            if (size > capacity) {
                LinkedNode tailNode = removeTail();
                cache.remove(tailNode.key);
                size--;
            }
        } else {
            v.value = value;
            cache.put(key, v);
            moveToTop(v);
        }
    }


    public void addToTop(LinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToTop(LinkedNode node) {
        removeNode(node);
        addToTop(node);
    }

    public LinkedNode removeTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public static void main(String[] args) {
        LRUDemo<Integer, Integer> lru = new LRUDemo<>(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(2, 1);
        System.out.println(lru);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        LinkedNode cur = head.next;
        while (cur != tail) {
            s.append(cur.value);
            cur = cur.next;
            if (cur != tail) {
                s.append(",");
            }
        }
        s.append("}");
        return s.toString();
    }
}
