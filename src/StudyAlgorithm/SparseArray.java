package StudyAlgorithm;

/**
 * @author dutu
 * @date 2021-04-15 20:29
 */
public class SparseArray {
    public static void main(String[] args) {
        // 0--无棋子,1--黑色棋子,2--白色棋子
        int originalArray[][] = new int[11][11];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;

        int[][] sparseRes = originalToSparse(originalArray);

        for (int[] row : sparseRes) {
            for (int dataRow : row) {
                System.out.printf("%d\t",dataRow);
            }
            System.out.println();
        }

        int[][] originalRes = sparseToOriginal(sparseRes);
        System.out.println("---------");
        for (int[] row : originalRes) {
            for (int dataRow : row) {
                System.out.printf("%d\t",dataRow);
            }
            System.out.println();
        }
    }
    // 原始--->压缩
    public static int[][] originalToSparse(int[][] originalArray){
        // 先确定行,列,有效值的数量---->压缩数组的行数
        int length = 0;
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[0].length; j++) {
                if (originalArray[i][j] != 0) length++;
            }
        }
        int[][] sparseArray = new int[length+1][3];
        sparseArray[0][0] = originalArray.length;
        sparseArray[0][1] = originalArray[0].length;
        sparseArray[0][2] = length;

        int index = 1;

        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray[0].length; j++) {
                if (originalArray[i][j] != 0){
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = originalArray[i][j];
                    index++;
                }
            }
        }
        return sparseArray;
    }
    // 压缩--->原始
    public static int[][] sparseToOriginal(int[][] sparseArray){
        // 先确定原始数组的行列
        int row = sparseArray[0][0];
        int col = sparseArray[0][1];

        int[][] originalArray = new int[row][col];

        for (int i = 1; i < sparseArray.length; i++) {
                originalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return originalArray;
    }
}
