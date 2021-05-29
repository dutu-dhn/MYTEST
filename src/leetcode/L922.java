package leetcode;

public class L922 {
    public static int[] sortArrayByParityII(int[] A) {
        //空数组判断
        if(A==null) return A;
        //偶数辅助数组
        int[] even = new int[A.length/2];
        //偶数数组索引
        int evenidex = 0;
        //奇数辅助数组
        int[] jishu = new int[A.length/2];
        //奇数数组索引
        int jishuidex = 0;
        //A数组中的奇数偶数分开放入相应的辅助数组
        for (int i = 0;i<A.length;i++){
            if(A[i]%2==0) {even[evenidex] = A[i];evenidex++;}
            else {jishu[jishuidex] = A[i];jishuidex++;}
        }
        //把辅助数组中的值按顺序注入到A数组
        evenidex = 0;
        jishuidex = 0;
        for (int i = 0;i<A.length;i=i+2){
            A[i] = even[evenidex];
            evenidex++;
        }
        for (int i = 1;i<A.length;i=i+2){
            A[i] = jishu[jishuidex];
            jishuidex++;
        }
        return A;
    }
    public static void main(String[] args) {
        int A[] = new int[]{4,2,5,7};
        for (int i:sortArrayByParityII(A)
             ) {
            System.out.println(i);
        }
    }
}
