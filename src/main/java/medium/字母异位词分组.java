package medium;

import java.util.*;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/1 14:34
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            } else {
                List<String> list = map.get(s);
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        map.forEach((k, v) -> res.add(v));
        return res;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(strs[i]);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }
}
