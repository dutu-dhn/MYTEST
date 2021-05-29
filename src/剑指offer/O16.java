package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-05 20:08
 */
public class O16 {

/*    public static double myPow(double x, int n) {
        double res = 1;
        if (x==0) return 0.0;
        if (x==1) return 1.0;
        if (n>0) {
            myPow(x,n-1);
*//*            while (n !=0){
                res = res*x;
                n--;

            }*//*
        }else if (n == 0){
            return 1;
        }else {
            x = 1/x;
            while (n !=0){
                res = res*x;
                n++;
            }
        }
        return res;
    }*/
    public static double myPow1(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow1(x, n / 2);
        double mod = myPow1(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {
        System.out.println(myPow1(2, 2));


    }
}
