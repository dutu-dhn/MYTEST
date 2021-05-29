package leetcode;

import java.util.Stack;

public class L20 {
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        if (s.length()==1) return false;
        for (int i = 0;i<s.length();i++){

            if (s.substring(i,i+1).equals("(")) stack.push(s.substring(i,i+1));
            else if (s.substring(i,i+1).equals("{")) stack.push(s.substring(i,i+1));
            else if (s.substring(i,i+1).equals("[")) stack.push(s.substring(i,i+1));
            else if (s.substring(i,i+1).equals(")")) {
                if (stack.size()==0) return false;
                else if (!stack.pop().equals("(")) {
                    return false;
                }
            }
            else if (s.substring(i,i+1).equals("}")) {
                if (stack.size()==0) return false;
                else if (!stack.pop().equals("{")) {
                    return false;
                }
            }
            else if (s.substring(i,i+1).equals("]")) {
                if (stack.size()==0) return false;
                else if (!stack.pop().equals("[")) {
                    return false;
                }
            }
        }
        if (stack.size()!=0) return false;
        return true;
    }

    public static boolean isValid1(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }
    public boolean isValid3(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
    public static void main(String[] args) {
        System.out.println(isValid("(("));
    }
}
