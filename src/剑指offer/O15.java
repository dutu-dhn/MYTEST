package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-04 9:46
 */
public class O15 {

    public static int hammingWeight(int n) {
        System.out.println("--"+n);

        String s=n+"";
        int res = 0;
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) == '1'){
                res++;
            }
        }



        return res;
    }
    public static int hammingWeight1(int n) {
        System.out.println("--"+n);
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(hammingWeight1(0b11111111111111111111111111111101));
    }
}
