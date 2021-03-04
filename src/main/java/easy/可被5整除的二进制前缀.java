package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/14 12:48
 */
public class 可被5整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int tail = 0;
        for (int i : A) {
            tail = tail * 2 + i;
//            tail = (tail > 9) ? tail - 10 : tail;
            tail = (tail > 4) ? tail - 5 : tail;
            if (tail == 0 || tail == 5) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;

    }
}
