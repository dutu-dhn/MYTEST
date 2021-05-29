package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-20 20:17
 */
public class O57 {
    public static void main(String[] args) {

    }
}


class solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = nums.length-1;

        while (i != j){
            if (target -nums[i] > nums[j]) i++;
            else if (target - nums[i] < nums[j]) j--;
            else {
                res[0] = nums[i];
                res[1] = nums[j];
                return res;
            }
        }

        return res;
    }
}

