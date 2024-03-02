package offer.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2022/10/17 20:50
 */
public class 水果成篮 {

    public static void main(String[] args) {
        水果成篮 test = new 水果成篮();
        System.out.println(test.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) {
            return fruits.length;
        }
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>(4);
        int res = 0;
        for (int i = 0; i < fruits.length; i++) {
            Integer count = map.getOrDefault(fruits[i], 0);
            map.put(fruits[i], ++count);
            while (map.size() > 2) {
                Integer leftCount = map.get(fruits[left]);
                leftCount = leftCount - 1;
                map.put(fruits[left], leftCount);
                if (leftCount == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
