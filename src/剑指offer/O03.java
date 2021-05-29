package 剑指offer;

import java.util.HashMap;

/**
 * @author dutu
 * @date 2021-03-18 8:44
 */
public class O03 {
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length-1;
        for (int i = 0;i<=n;i++){
            int temp = nums[i];
            if (map.get(temp) == null){
                map.put(temp,1);
            }else {
                return temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(array));
    }
}
