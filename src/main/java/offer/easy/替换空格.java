package offer.easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/17 16:19
 */
public class 替换空格 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return String.valueOf(array);
    }


}
