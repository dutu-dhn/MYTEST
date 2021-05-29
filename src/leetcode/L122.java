package leetcode;

/**
 * @author dutu
 * @date 2020-11-26 16:17
 */
public class L122 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i]<prices[i+1]) {
                res = res+prices[i+1]-prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,2,5,6,1,4};
        System.out.println(maxProfit(prices));
    }
}
