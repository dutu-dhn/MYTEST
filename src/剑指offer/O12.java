package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-02 9:07
 */
public class O12 {
    public static boolean exist(char[][] board, String word) {
        // 逐个遍历,找到第一个目标数字,上下左右比较,同,则下一个目标数字与上下左右数字比较,但不包括来时路径

        // 索引
        int i = 0;
        int j = 0;

        int sindex = 0;

        // 边界
        int iborder = board[0].length;
        int jborder = board.length;

        while (i != iborder && j != jborder){
            if (board[i][j] == word.charAt(sindex)){
                sindex++;


            }else{
                if (i<iborder) i++;
                else {
                    i = 0;
                    j++;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},
                                    {'S','F','C','S'},
                                    {'A','D','E','E'}};

        exist1(board,"ABCCED");
    }

    public static boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.println("for");
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

}
