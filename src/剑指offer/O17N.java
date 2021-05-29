package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-07 20:15
 */
public class O17N {
/*    public static int[] printNumbers(int n) {
        // int size = 0;
//        while(n != 0){
//            size = size*10 + 9;
//            n--;
//        }
        int size = (int)Math.pow(10, n) - 1;

        int[] result = new int[size];

        for (int i = 1;i<=size;i++){
            result[i-1] = i;
        }

        return result;
    }*/

    public static void main(String[] args) {
        int[] ints = printNumbers1(2);

    }



    static int[] res;
    static int count = 0;

    public static int[] printNumbers1(int n) {
        res = new int[(int)Math.pow(10, n) - 1];
        for(int digit = 1; digit < n + 1; digit++){
            for(char first = '1'; first <= '9'; first++){
                char[] num = new char[digit];
                num[0] = first;
                dfs(1, num, digit);
            }
        }
        return res;
    }

    private static void dfs(int index, char[] num, int digit){
        if(index == digit){
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; i++){
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }

}
