package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/27 14:45
 */
public class 同构字符串 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));

    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (m1.get(a) == null && m2.get(b) == null) {
                m1.put(a, b);
                m2.put(b, a);
            } else if ((m1.containsKey(a) && m1.get(a) != b) || (m2.containsKey(b) && m2.get(b) != a)) {
                return false;
            }

        }

        return true;

    }


}

