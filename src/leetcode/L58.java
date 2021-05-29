package leetcode;

public class L58 {
    public static int lengthOfLastWord1(String s) {
        String[] res = s.split(" ");
        if (s.isEmpty()) return 0;
        if (res.length>=1)
            return res[res.length-1].length();
        else return 0;
    }
    public static int lengthOfLastWord(String s) {
        s= s.trim();
        int res = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i)!=' ') res++;
            else return res;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a b aa bb"));

    }
}
