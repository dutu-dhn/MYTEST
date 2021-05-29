package algorithm;

public class Insertion_sort {
    public static void sort(int[] nums){
        utils utils = new utils();
        int N = nums.length;
        for (int i = 1; i <N; i++) {
            for (int j = i; j>0&&(nums[j]<nums[j-1]) ; j--) {
                utils.swap(nums,j,j-1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,7,3,1};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
