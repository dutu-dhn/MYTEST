package StudyAlgorithm.递归;

/**
 * 八皇后
 * @author dutu
 * @date 2021-05-13 20:16
 */
public class demo2 {

    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {

        demo2 demo2 = new demo2();
        demo2.check(0);

        System.out.printf("一共有%d解法",count);
        System.out.printf("一共判断冲突的次数%d次",judgeCount);


    }
    private void check(int n){
        if (max == n) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;

            if (judge(n)){
                check(n+1);
            }
        }
    }


    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }

        return true;
    }

    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "");
        }
        System.out.println();
    }

}
