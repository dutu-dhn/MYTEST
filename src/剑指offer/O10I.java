package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-23 21:37
 */
public class O10I {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(50));
    }
    public static int fib(int n) {
        if (n == 1){
            return 1;
        }else if (n == 0){
            return 0;
        }else {
            int temp = fib(n-1) + fib(n-2);
            if (temp >= (1e9+7))
            return (int) (temp % (1e9+7));
            else return temp;
        }
    }
}
