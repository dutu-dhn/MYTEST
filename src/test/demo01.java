package test;

public class demo01 {
    public static void  main(String[] args) {
        int[] nums = {3,2,4};

        int target = 6;

        System.out.println(twoSum(nums,target));
    }

    public static int[] twoSum(int[] nums, int target) {
        int size = nums.length-1;
        int[] out = new int[2];
        for(int i=0;i<size;i++){
            for(int j=i+1;j<=size;j++){
                System.out.println("i--"+i+"--"+nums[i]);
                System.out.println("j--"+j+"--"+nums[j]);
                if((nums[i]+nums[j])==target){
                    System.out.println(i);
                    System.out.println(j);
                    out[0] = i;
                    out[1] = j;
                    System.out.println(out[0]);
                    System.out.println(out[1]);
                    return out;
                }
            }
        }
        return null;
    }
}
