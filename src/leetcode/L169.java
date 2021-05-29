package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutu
 * @date 2020-12-01 13:23
 */
public class L169 {
    //map
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            //判断数是否在map中,在就加一,不在就加入值为一
            if (map.isEmpty()||map.get(nums[i])==null){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        //遍历判断
        for (Integer key: map.keySet()
             ) {
            if (map.get(key)>n/2) return key;
        }
        return -1;
    }
    public static int majorityElement1(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
             count += (num == candidate) ? 1 : -1;
        }

        return candidate;

    }
    public static void main(String[] args) {
        int[] nums = new int[]{6,5,5};
        System.out.println(majorityElement1(nums));

    }
}
