package offer.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/20 19:39
 */
public class 栈的压入弹出序列 {
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && popped[i] == num) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
