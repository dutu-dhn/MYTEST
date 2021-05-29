package leetcode;

public class L53 {
    public static int maxSubArray1(int[] nums) {
        if (nums.length==1) return nums[0];
//        int start = 0;
//        int end = 0;
        int res = nums[0];
        int temp = 0;
        int step = 1;
        while(step<=nums.length){
            for (int i = 0; i <nums.length ; i++) {
                if ((step+i)>nums.length) break;
                for (int j = i;(step+i<=nums.length)&& j < step+i; j++) {
                    temp = temp +nums[j];
                    if (temp>res){
                        res = temp;
                    }
                }temp=0;
            }
            step++;
       }

        return res;
    }
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1};
        System.out.println(maxSubArray(nums));

    }
}
