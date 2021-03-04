package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/26 20:08
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        无重复字符的最长子串 test = new 无重复字符的最长子串();
//        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("pwazwkew"));
        System.out.println(test.lengthOfLongestSubstring("bbbb"));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
