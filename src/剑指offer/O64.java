package 剑指offer;

/**
 * @author dutu
 * @date 2021-05-10 22:15
 */
public class O64 {
    public int sumNums(int n) {
        if(n == 1) return 1;
        n += sumNums(n - 1);
        return n;
    }


    public static void main(String[] args) {
        O64 t = new O64();
        System.out.println(t.sumNums(3));
    }
}
