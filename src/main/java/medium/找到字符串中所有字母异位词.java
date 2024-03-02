package medium;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhangyi
 * @email zhangyi04@zhuanzhuan.com
 * @date 2024/2/18 16:21
 */
public class 找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        找到字符串中所有字母异位词 test = new 找到字符串中所有字母异位词();
        List<Integer> anagrams = test.findAnagrams("cbaebabacd", "abc");
        System.out.println(anagrams);


    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pCountMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pCountMap.put(p.charAt(i), pCountMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i + p.length() <= s.length()) {
            String sub = s.substring(i, i + p.length());
            if (isAnagrams(sub, pCountMap)) {
                res.add(i);
            }
            i++;
        }
        return res;
    }

    private boolean isAnagrams(String sub, Map<Character, Integer> pCountMap) {
        Map<Character, Integer> subCountMap = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            subCountMap.put(sub.charAt(i), subCountMap.getOrDefault(sub.charAt(i), 0) + 1);
        }
        AtomicBoolean b = new AtomicBoolean(true);
        pCountMap.forEach((k, v) -> {
            if (!v.equals(subCountMap.get(k))) {
                b.set(false);
                return;
            }
        });
        return b.get();
    }

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int[] cnt = new int[26];
            for(int i = 0; i < p.length(); i++){
                cnt[p.charAt(i) - 'a']++;
            }
            int l = 0;
            for(int r = 0; r < s.length(); r++){
                cnt[s.charAt(r) - 'a']--;
                while(cnt[s.charAt(r) - 'a'] < 0){
                    cnt[s.charAt(l) - 'a']++;
                    l++;
                }
                if(r - l + 1 == p.length()){
                    ans.add(l);
                }
            }
            return ans;
        }
    }

}
