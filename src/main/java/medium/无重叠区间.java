package medium;

import java.util.Arrays;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2020/12/31 16:24
 */
public class 无重叠区间 {
    public static void main(String[] args) {
        eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //先排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
