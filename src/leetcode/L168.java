package leetcode;

/**
 * @author dutu
 * @date 2020-11-30 21:27
 */
public class L168 {
    public static String convertToTitle(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            n--; // 依次获取 26 进制逻辑上的个位、十位、百位…（虽然在 26 进制中不这么叫）
            stringBuilder.append((char) ('A' + n % 26));
            n /= 26;
        }
        return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(703));
    }
}
