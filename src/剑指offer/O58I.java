package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-20 20:25
 */
public class O58I {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.reverseWords("  hello world!  "));
    }
}

class Solution1 {
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        s = s.trim(); // 删除首尾空格
        int m = s.length()-1;//j
        int k = m;//i

        while (k>=0){
/*            if (s.substring(k-1,k).equals(" ")){
                k--;
                res.append(s.substring(k,m));
                m = k;
            }else {
                k--;
                if (k==0) res.append(" "+s.substring(k,m));
            }*/

            while(k >= 0 && s.charAt(k) != ' ') k--; // 搜索首个空格
            res.append(s.substring(k + 1, m + 1) + " "); // 添加单词
            while(k >= 0 && s.charAt(k) == ' ') k--; // 跳过单词间空格
            m = k; // j 指向下个单词的尾字符

        }

        return res.toString().trim();
    }
}