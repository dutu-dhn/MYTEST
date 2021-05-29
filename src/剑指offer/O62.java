package 剑指offer;

import java.util.ArrayList;

/**
 * @author dutu
 * @date 2021-04-22 21:38
 */
public class O62 {
    public static void main(String[] args) {

    }
}
class SolutionlastRemaining {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        int idx = 0;
        while (n>1){
            idx = (idx + m - 1) % n;
            arrayList.remove(idx);
            n--;
        }

        return arrayList.get(0);
    }
}