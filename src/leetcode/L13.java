package leetcode;

import java.util.HashMap;
import java.util.Map;

public class L13 {
    //解法一
    public static int romanToInt(String s) {

        Map rome = new HashMap<String, Integer>();
        rome.put("I",1);
        rome.put("V",5);
        rome.put("X",10);
        rome.put("L",50);
        rome.put("C",100);
        rome.put("D",500);
        rome.put("M",1000);

        int result = 0;
        int[] numeral = new int[s.length()];
        for (int i = 0;i<s.length();i++){
            numeral[i] = (int)rome.get(s.substring(i,i+1));

        }
        for (int i = 0;i<s.length()-1;i++){
            if (numeral[i]<numeral[i+1]){
                numeral[i+1] =numeral[i+1] - numeral[i];
                numeral[i] = 0;
            }

        }
        for (int i:numeral
        ) {
            result = result +i;
        }
        return  result;
    }
    //解法二
    public static int romanToInt1(String s) {

        int result = 0;
        int[] numeral = new int[s.length()];
        for (int i = 0;i<s.length();i++){
            numeral[i] = getValue(s.charAt(i));

        }
        for (int i = 0;i<s.length()-1;i++){
            if (numeral[i]<numeral[i+1]){
                numeral[i+1] =numeral[i+1] - numeral[i];
                numeral[i] = 0;
            }

        }
        for (int i:numeral
        ) {
            result = result +i;
        }
        return  result;
    }
    //解法三
    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    //解法二
    private static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt1("XXVII"));
    }
}
