package offer.thread.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/24 20:54
 */
public class LRUCache<k, v> extends LinkedHashMap<k, v> {

    private int capacity;//坑位

    public LRUCache(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.capacity = initialCapacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return super.size() > capacity;
//        return false;
    }

    public static void main(String[] args) {

        Map<Object, Object> lruCache = new LRUCache<Object, Object>(3);
        lruCache.put(1, 2);
        lruCache.put(2, 2);
        lruCache.put(3, 2);
        System.out.println(lruCache.keySet());
        lruCache.put(4, 2);
        System.out.println(lruCache.keySet());
        lruCache.put(3, 2);
        System.out.println(lruCache.keySet());
        lruCache.put(3, 2);
        System.out.println(lruCache.keySet());
        lruCache.put(5, 2);
        System.out.println(lruCache.keySet());
    }
}
