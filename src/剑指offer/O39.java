package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutu
 * @date 2021-04-17 21:56
 */
public class O39 {
    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
                if (map.get(nums[i])*2 > nums.length) return nums[i];
            }
        }

        return nums[0];
    }

    public static int majorityElement1(int[] nums) {
/*        int target = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                count++;
            }else {
                if (count>0) count--;
                else {
                    target = nums[i];
                    count=1;
                }
            }
        }*/
        int target = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) target = num;
            count = count + num == target ? 1 : -1;
        }
        return target;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,4};
        System.out.println(majorityElement1(nums));
    }
}
