package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-16 17:04
 */
public class O50 {
    public static char firstUniqChar(String s) {
        if (s.equals("")) return ' ';
        int target[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            target[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        }

        return ' ';


    }
    public static void main (String[]args){
        String s = "leetcode";
        System.out.println(firstUniqChar(s));

    }
}