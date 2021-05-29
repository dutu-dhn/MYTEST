package leetcode;

public class L14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        else if (strs.length==1) return strs[0];
        else {
            String result1 = check(strs[0],strs[1]);
            if (strs.length==2) return result1;
            for (int i = 1; i<strs.length-1;i++){
                if (result1.equals("")) return "";
                else {
                    if (result1.length()>check(strs[i],strs[i+1]).length())
                    {result1 = check(strs[i],strs[i+1]);}
                }
            }
                return result1;
        }

    }
    public static String check(String s1,String s2){
        String result = "";
        int size = 0;
        if (s1.length()>s2.length()) size = s2.length();
        else size = s1.length();

        for (int i = 0;i<size;i++){
            if (s1.substring(i,i+1).equals(s2.substring(i,i+1))){
                result += s1.substring(i, i + 1);}
            else return result;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abcd","asdf"};

        System.out.println(strs[1].matches("asdf"));
        System.out.println(longestCommonPrefix(strs));
    }
}
