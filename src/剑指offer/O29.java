package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-11 13:06
 */
public class O29 {
    public static int[] spiralOrder(int[][] matrix) {

        // 左
        int l = 0;
        // 右
        int r = matrix[0].length-1;
        // 上
        int t = 0;
        // 下
        int b = matrix.length-1;

        int x = 0;

        int[] res = new int[(r+1)*(b+1)];

        while(true) {
            for(int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if(++l > r) break;
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] matrix =new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        spiralOrder(matrix);

    }
}
