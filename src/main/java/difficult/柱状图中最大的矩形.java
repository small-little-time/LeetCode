package difficult;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/30 17:21
 */
public class 柱状图中最大的矩形 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1, 1, 1}));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            arr[i] = heights[i];
        }
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                int h = arr[st.pop()];
                int len = st.empty() ? i : (i - st.peek() - 1);
                ans = Math.max(ans, h * len);
            }
            st.push(i);
        }
        return ans;
    }

    public static int largestRectangleArea2(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int a = stack.pop();
                int b = stack.peek();
                int c = heights[a];
                int area = c * (i - b - 1);
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int area = heights[stack.pop()] * (stack.size() - stack.peek() - 1);
            max = Math.max(max, area);
        }

        return max;
    }
}
