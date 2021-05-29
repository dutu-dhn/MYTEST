package leetcode;

public class L27 {
    public static int removeElement(int[] nums, int val) {
        //输入数组为空直接返回0
        if(nums.length==0) return 0;
        //双指针--主定位:指针前是复符合条件的数据
        int i = 0;
        //双指针--辅助定位:循环查找复合条件的下标
        int j = 0;
        while(j<nums.length){
            //如果辅助指针与val相等,辅助指针去找下一个
            if (nums[j]==val){
                j++;
             //如果辅助指针与val不等于val的值给主指针  主指针+1
            }else{
//                int temp = 0;
//                temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
                nums[i] = nums[j];
                i++;
                //j=i;
                j++;
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
       return i;
    }
    public static int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,5,2};

        System.out.println("res:"+removeElement(nums,2));
    }
}
