package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-03 13:04
 */
public class O13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }
    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i >= m || j >= n || k < getSum(i) + getSum(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

    private int getSum(int a) {
        int sum = a % 10;
        int tmp = a / 10;
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        return sum;
    }
}
