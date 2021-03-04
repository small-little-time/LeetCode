package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/29 19:37
 */
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("()))"));
        System.out.println(isValid2("({]]"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        Stack<String> stack = new Stack<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                list.add(c);
                if (stack.empty()) {
                    continue;
                }
                String peek = stack.peek();
                if (map.get(peek).equals(c)) {
                    stack.pop();
                    list.removeFirst();
                } else {
                    return false;
                }
            }
        }

        return stack.empty() && list.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.empty();
    }
}
