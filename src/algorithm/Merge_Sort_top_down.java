package algorithm;

import java.util.Arrays;

//自顶向下
public class Merge_Sort_top_down {
    private  static int[] aux;
    public static void sort(int[] nums){
        aux = new int[nums.length];
        sort(nums,0,nums.length-1);

    }
    public static void sort(int[] nums,int left,int right){
        //递归结束条件
        if (right<=left) return;
        int mid = (left+right)/2;
        //左边排序
        sort(nums,left,mid);
        //右边排序
        sort(nums,mid+1,right);
        //合并
        merge(nums,left,mid,right);
    }

    public static void merge(int[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;

        for (int k = left; k <= right; k++) {
            aux[k] = nums[k];
        }

        for (int k = left; k <= right; k++) {
            //合并时若有一侧为空,则另一侧依次放入原数组
            if (i>mid)              nums[k] = aux[j++];
            else if (j>right)       nums[k] = aux[i++];
            //两侧小的先放入原数组
            else if (aux[j]<aux[i]) nums[k] = aux[j++];
            else                    nums[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,2,3,4,35,4,54,36,54,6,5,6,2,3423};
        sort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
