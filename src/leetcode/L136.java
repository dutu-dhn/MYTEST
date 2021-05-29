package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutu
 * @date 2020-11-27 15:25
 */
public class L136 {
    //暴力
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)){
                map.remove(num);
            }else{
                map.put(num,1);
            }
        }
        for(Integer key : map.keySet()){
            if (map.get(key)==1){
                return key;
            }
        }
        return -1;
    }
    //异或
    public static int singleNumber1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res^nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
}
