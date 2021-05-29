package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-17 8:45
 */
public class O58II {
    //1 <= k < s.length <= 10000

    public static String getString(String s,int n){
        String result = "";

        int length = result.length();

        String temp = s.substring(0,n);

        String temp1 = s.substring(n,s.length());

        result = temp1 + temp;

        return result;
    }

    public static void main(String[] args) {
        String s = "a";
        int n = 0;
        System.out.println(getString(s, n));
    }
}
