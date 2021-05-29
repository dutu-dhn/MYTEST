package leetcode;

import java.util.Arrays;

public class L283 {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if (nums[j]!=0){
                int temp = 0;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }else j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
