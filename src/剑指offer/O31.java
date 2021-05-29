package 剑指offer;

import java.util.Stack;

/**
 * @author dutu
 * @date 2021-04-12 21:15
 */
public class O31 {

   /* public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();

        if (pushed.length == 0){
            return true;
        }

        int pushindex = 0;
        int popindex = 0;
        stack.push(pushed[pushindex]);
        for (int i = 0;i<pushed.length;i++){

            if (stack.peek() == popped[popindex]){
                stack.pop();
                popindex++;
            }else {
                pushindex++;
                stack.push(pushed[pushindex]);

            }


        }


        while (!stack.isEmpty()){
            if (stack.pop() == popped[popindex]) popindex++;
            else return false;
        }

        return true;
    }
*/

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,0};
        int[] popped = new int[]{1,0};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
