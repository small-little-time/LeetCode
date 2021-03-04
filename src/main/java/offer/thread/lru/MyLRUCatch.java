package offer.thread.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/28 2:27
 */
public class MyLRUCatch {
    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode() {
        }

        public LinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head, tail;

    public MyLRUCatch(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            LinkedNode newNode = new LinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                LinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LinkedNode removeTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}
