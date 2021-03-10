package offer.other;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/2/25 23:44
 */
public class test {
    public static void main(String[] args) {
        test test = new test();
        System.out.println(test.getClass().getClassLoader());
        System.out.println(test.res("255.255.255.255"));
        System.out.println(test.res2("255.255.255.255"));
    }

    private int res(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') {
                char c = s.charAt(i);
                res = res * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        return res;
    }

    private Long res2(String s) {
        Long res = 0L;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '.') {
                res = res * 10 + Long.parseLong(String.valueOf(s.charAt(i)));
            }
        }
        return res;
    }
}
