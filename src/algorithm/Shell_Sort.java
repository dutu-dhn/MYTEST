package algorithm;

public class Shell_Sort {
    public static void sort(int[] nums){
        utils utils = new utils();
        int N = nums.length;

        int h = 1;
        while(h<N/3) h = h*3+1;

        while(h>=1){
            for (int i = h; i <N; i++) {
                for (int j = i; j>=h&&(nums[j]<nums[j-h]) ; j -= h) {
                    utils.swap(nums,j,j-h);
                }
            }
            h = h/3;
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
