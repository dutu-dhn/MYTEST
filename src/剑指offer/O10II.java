package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-29 13:30
 */
public class O10II {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
