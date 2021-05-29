package 剑指offer;

/**
 * @author dutu
 * @date 2021-04-08 14:42
 */
public class O21 {
    public static int[] exchange(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;
        int [] res = new int[nums.length];

        int pre = 0;
        int aft = nums.length-1;

        for (int i = 0; i<nums.length;i++){

            if (nums[i]%2!=0){
                res[pre] = nums[i];
                pre++;
            }else {
                res[aft] = nums[i];
                aft--;
            }
            if (pre > aft ) return res;
        }

        return res;

    }

    public static int[] exchange1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;

        int pre = 0;
        int aft = nums.length-1;

        while (pre <= aft){
            if (nums[pre]%2!=0){
                pre++;
            }else if (nums[aft]%2==0){
                aft--;
            }else if (nums[pre]%2 ==0 && nums[aft]%2!=0){
                int temp;
                temp = nums[pre];
                nums[pre] = nums[aft];
                nums[aft] = temp;
                pre++;
                aft--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        for (int i : exchange1(nums)) {
            System.out.println(i);
        }
    }
}
