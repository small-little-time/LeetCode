package offer.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/17 18:50
 */
public class 用两个栈实现队列 {

    public static void main(String[] args) {

    }

    public Deque<Integer> stack1;
    public Deque<Integer> stack2;

    public 用两个栈实现队列() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
