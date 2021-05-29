package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-19 16:19
 */
public class O04 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};

        System.out.println(findNumberIn2DArray(matrix, 20));

    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                System.out.println(matrix[i][j]);
                if (target < matrix[i][j]){
                    break;
                }
                if (target == matrix[i][j]){
                    return true;
                }
            }
        }

        return false;
    }

}
