package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-18 20:16
 */
public class O67 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("12"));
        char a = '0';
        char b = '9';

    }
}

class Solution {
    public int strToInt(String str) {
        //去除首位空格
        char[] c = str.trim().toCharArray();
        //若str为空返回0
        if(c.length == 0) return 0;
        //设置一个结果int 和 判断是否数值范围是否超
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        // 索引  sign  1:+
        int i = 1, sign = 1;
        //判断首位符号
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;

        for(int j = i; j < c.length; j++) {
            if(c[j] < '0' || c[j] > '9') break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}