package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        for (int i = 0; i <s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i)==t.charAt(j)){
                    t = t.replaceFirst(String.valueOf(t.charAt(j)),"");
                    break;
                }
            }
        }
        if (t.equals("")) return true;
        return false;
    }
    public static boolean isAnagram1(String s, String t) {
        if (s.equals(t)) return true;
        if (s.length()!=t.length()) return false;
        Map<Character, Integer> sm = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if (sm.get(s.charAt(i))!=null){
                sm.replace(s.charAt(i),sm.get(s.charAt(i))+1);
            }else sm.put(s.charAt(i),1);
        }
        for (int i = 0; i <t.length() ; i++) {
            if (sm.get(t.charAt(i))!=null&&sm.get(t.charAt(i))>1){
                sm.replace(t.charAt(i),sm.get(t.charAt(i))-1);
            }else if (sm.get(t.charAt(i))!=null&&sm.get(t.charAt(i))==1){
                sm.remove(t.charAt(i));
            }else
                return false;

        }
        for (char key :sm.keySet()) {
            System.out.println("key：" + key + "，value:" + sm.get(key));
        }
        return sm.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(isAnagram1("abc","bca"));
    }
}
