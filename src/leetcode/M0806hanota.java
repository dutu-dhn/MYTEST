package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dutu
 * @date 2021-05-13 21:01
 */
public class M0806hanota {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

    }
}
class HanotaSolution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(),A,B,C);
    }

    public void move(int n,List<Integer> A, List<Integer> B, List<Integer> C){
        if (n == 1){
            C.add(A.remove(A.size() - 1));
        }else {
            move(n -1,A,C,B);
            C.add(A.remove(A.size() - 1));
            move(n - 1,B,A,C);

        }
    }
}