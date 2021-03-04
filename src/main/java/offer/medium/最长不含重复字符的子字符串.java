package offer.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/23 16:46
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        最长不含重复字符的子字符串 test = new 最长不含重复字符的子字符串();
        System.out.println(test.lengthOfLongestSubstring("dvdf"));
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;


    }

    public int lengthOfLongestSubstring2(String s) {
        //if(s==null) return 0;这句话可以不加，s.length()长度为0时，不进入下面的循环，会直接返回max=0;
        //划定当前窗口的坐标为(start,i],左开右闭,所以start的初始值为-1，而非0。
        int max = 0, start = -1;
        //使用哈希表map统计各字符最后一次出现的索引位置
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            //当字符在map中已经存储时，需要判断其索引值index和当前窗口start的大小以确定是否需要对start进行更新:
            //当index>start时，start更新为当前的index,否则保持不变。
            //注意若index作为新的start，计算当前滑动空间的长度时也是不计入的，左开右闭，右侧s[i]会计入，这样也是防止字符的重复计入。
            if (map.containsKey(tmp)) {
                start = Math.max(start, map.get(tmp));
            }

            //如果map中不含tmp，此处是在map中新增一个键值对，否则是对原有的键值对进行更新
            map.put(tmp, i);

            //i-start,为当前滑动空间(start,i]的长度，若其大于max，则需要进行更新。
            max = Math.max(max, i - start);
        }
        return max;
    }
}
