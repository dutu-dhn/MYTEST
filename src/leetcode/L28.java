package leetcode;

public class L28 {
    public static int strStr(String haystack, String needle) {

        if (needle.equals("")||needle.equals(haystack)) return 0;
        for (int i = 0;i+needle.length()<=haystack.length();i++){
            if (haystack.substring(i,i+needle.length()).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "abc";
        String needle = "c";
        System.out.println(strStr(haystack,needle));
    }
}
