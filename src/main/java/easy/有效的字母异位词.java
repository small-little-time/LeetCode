package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/1 13:40
 */
public class 有效的字母异位词 {
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                int k = map.get(a) + 1;
                map.put(a, k);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char a = s.charAt(i);
            if (!map.containsKey(a)) {
                return false;
            } else {
                int k = map.get(a) - 1;
                map.put(a, k);
            }
        }
        AtomicInteger res = new AtomicInteger();
        map.forEach((k, v) -> {
            if (v != 0) {
                res.set(1);
            }
        });

        return res.get() == 0;
    }
}
