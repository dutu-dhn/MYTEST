package 剑指offer;

/**
 * @author dutu
 * @date 2021-05-12 20:39
 */
public class O63 {
    public static void main(String[] args) {
        O63Solution o63Solution = new O63Solution();
        System.out.println(Math.abs(o63Solution.maxProfit1(new int[]{7,1,5,3,6,4})));

    }
}

class O63Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] > prices[j]) break;
                if (prices[i] - prices[j] < result){
                    result = prices[i] - prices[j];
                }
            }
        }
        return result;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int result = 0;
        int minprice = prices[0];
        for (int i = 0; i < prices.length; i++) {

            minprice = Math.min(prices[i],minprice);
            result = Math.max(result,prices[i]-minprice);


        }
        return result;
    }
}
