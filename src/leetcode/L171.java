package leetcode;

/**
 * @author dutu
 * @date 2020-12-01 14:18
 */
public class L171 {
    public static int titleToNumber(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("XY"));
    }
}
