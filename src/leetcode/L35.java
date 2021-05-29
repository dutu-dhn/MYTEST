package leetcode;

public class L35 {
    public static int searchInsert(int[] nums, int target) {
        if(nums.length==0||target==0||nums[0]>=target) return 0;
        if(nums[nums.length-1]<target) return nums.length;
        int start = 0;
        int end = nums.length-1;
        int index = (start+end)/2;
        while (start<=end){
            if ((end-start)==1) return index+1;
            if (nums[index]<target){
                start = index;
                index = (start+end)/2;
            }else if(target<nums[index]){
                end = index;
                index = (start+end)/2;
            }else{
                return index;
            }

        }
        return index;
    }
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5};
        System.out.println(searchInsert(nums,1));

    }
}
