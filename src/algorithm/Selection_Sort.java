package algorithm;

public class Selection_Sort {
    public static void sort(int[] nums){
        utils utils = new utils();
        int N = nums.length;
        for (int i = 0; i <N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            utils.swap(nums, i, min);
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
