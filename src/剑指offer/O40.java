package 剑指offer;

import java.util.Arrays;

/**
 * @author dutu
 * @date 2021-04-25 19:35
 */
public class O40 {
}
class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }
}
