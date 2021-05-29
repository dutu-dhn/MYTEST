package 剑指offer;

/**
 * @author dutu
 * @date 2021-05-09 10:13
 */
public class O66 {
    public static int[] constructArr(int[] a) {
        if (a.length==0) return a;
        int temp = 1;
        int[] res = new int[a.length];
        res[0] = 1;

        for (int i = 1; i < a.length; i++) {
            res[i] = a[i-1]*res[i-1];
        }
        for (int i = a.length-2; i>0; i--) {
            temp *= a[i+1];
            res[i] = res[i] * temp;
        }



/*        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i!=j){
                    temp = temp*a[j];
                }
            }
            res[i] = temp;
            temp = 1;
        }*/
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1};
        for (int i : constructArr(a)) {
            System.out.print(i+" ");
        }
    }
}
