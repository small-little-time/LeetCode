package easy;

/**
 * @author ZhangYi zhangyi-time@foxmail.com
 * @date 2021/1/6 15:53
 */
public class 买卖股票的最佳时机 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] >= prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }
}
