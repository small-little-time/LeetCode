package easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/1 11:56
 */
public class 种花问题 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0, count = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                num++;
                count = 1;
            }
        }
        if (count == 2 && flowerbed[flowerbed.length - 1] == 0) {
            num++;
        }

        return num >= n;
    }

}
