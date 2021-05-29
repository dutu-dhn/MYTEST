package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L402 {

    public static String removeKdigits2(String num, int k){
        if (num.length()==k) return "0";
        Stack<Integer> res = new Stack<>();
        for (int i = 0;i<num.length();i++){
            int temp = num.charAt(i)-'0';
            if (res.empty()) res.push(temp);
            else{
                if (res.peek()<temp) res.push(temp);
                else{
                    while(!res.empty()&&res.peek()>temp&&k>0){
                        res.pop();
                        k=k-1;
                        //if (k==0) break;
                    }
                    res.push(temp);
                }
            }
        }
        if (k>0){
            while(k!=0){
                res.pop();
                k=k-1;
            }
        }
        String result = "";
        for (Integer re : res) {
            if (result.equals("")&&re==0&&res.size()>1);
            else result=result+re;
        }
        if (result.equals("")) return "0";
        return result;
    }
    public String removeKdigits1(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }


    public static void main(String[] args) {

        System.out.println(removeKdigits2("1432219",3));
    }
}
