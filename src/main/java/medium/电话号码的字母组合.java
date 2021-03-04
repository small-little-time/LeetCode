package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/4 19:32
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        search(res, digits, map, "", 0);
        return res;

    }

    private static void search(List<String> res, String digits, Map<Character, String> map, String s, int i) {
        if (i == digits.length()) {
            res.add(s);
            return;
        }
        String letters = map.get(digits.charAt(i));
        for (int j = 0; j < letters.length(); j++) {
            search(res, digits, map, s + letters.charAt(j), i + 1);
        }
    }


}
