package leetcode;

/**
 * @author dutu
 * @date 2020-11-26 11:34
 */
public class L121 {
    public static int maxProfit(int[] prices) {
        //结果
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i]>res){
                    res = prices[j]-prices[i];
                }
            }
        }
        return res;
    }
    //动态规划
    public static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;

    }
    public static void main(String[] args) {
        int[] prices = new int[]{7,2,5,6,1,4};
        System.out.println(maxProfit1(prices));
    }
}
