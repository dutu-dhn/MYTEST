package 剑指offer;

/**
 * 任何大于1的数都可由2和3相加组成（根据奇偶证明）
 * 因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
 * 因为2*2*2<3*3, 所以3越多积越大 时间复杂度O(n/3)，用幂函数可以达到O(log(n/3)), 因为n不大，所以提升意义不大，我就没用。 空间复杂度常数复杂度O(1)
 * @author dutu
 * @date 2021-04-03 13:40
 */
public class O14I {
    public static int cuttingRope(int n) {
        int sum = 1;

        if (n == 2) return 1;
        if (n == 3) return 2;
            while (n!=0){
                if (n-3==2){
                    sum = sum*3*2;
                    break;
                }
                else if (n-3==0){
                    sum = sum*3;
                    break;
                }
                else if (n-3 == 1){
                    sum = sum*4;
                    break;
                }else {
                    n = n-3;
                    sum = sum*3;
                }

        }

        return sum;
    }

    public static int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope1(20));
    }

}
