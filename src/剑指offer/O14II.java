package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-04 9:21
 */
public class O14II {
    public static int cuttingRope(int n) {
        long sum = 1;

        if (n == 2) return 1;
        if (n == 3) return 2;
/*        while (n!=0){
            if (n-3==2){
                sum = (sum*3*2)%1000000007;
                break;
            }
            else if (n-3==0){
                sum = (sum*3)%1000000007;
                break;
            }
            else if (n-3 == 1){
                sum = (sum*4)%1000000007;
                break;
            }else {
                n = n-3;
                sum = (sum*3)%1000000007;
            }

        }*/
        while(n > 4){
            sum *= 3;
            sum = sum % 1000000007;
            n -= 3;
        }

        return (int) (sum*n%1000000007);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(1000));
    }

}
