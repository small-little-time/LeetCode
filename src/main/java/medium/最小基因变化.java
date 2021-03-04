package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/5 15:27
 */
public class 最小基因变化 {
    public static void main(String[] args) {
//        System.out.println(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
//        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
//        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(minMutation("AGCAAAAA", "GACAAAAA", new String[]{"AGTAAAAA", "GGTAAAAA", "GATAAAAA", "GACAAAAA"}));
    }

    public static int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> setBank = new HashSet<>();
        Set<Character> setDictionary = new HashSet<>();
        for (String s : bank) {
            setBank.add(s);
        }
        for (int i = 0; i < end.length(); i++) {
            setDictionary.add(end.charAt(i));
        }
        Set<Integer> resList = new HashSet<>();
        return mutation(start, end, setBank, setDictionary, 0, 0, resList);
    }

    public static int mutation(String start, String end, Set<String> bank, Set<Character> dictionary, int num, int index, Set<Integer> resList) {
        if (num == -1) {
            return -1;
        }
        if (index == end.length() && !start.equals(end)) {
            return -1;
        }
        if (start.equals(end)) {
            return num;
        }
        for (int i = index; i < start.length(); i++) {
            StringBuilder s = new StringBuilder(start);
            for (Character d : dictionary) {
                String replace = String.valueOf(s.replace(i, i + 1, String.valueOf(d)));
                if (bank.contains(replace)) {
                    int res = mutation(replace, end, bank, dictionary, num + 1, index + 1, resList);
                    resList.add(res);
                }
            }
        }
        for (Integer s : resList) {
            if (s != -1) {
                return s;
            }
        }
        return -1;

    }


}
