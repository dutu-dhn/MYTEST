package algorithm;

import java.util.Arrays;

//自底向上
public class Merge_Sort_bottom_up {
    private  static int[] aux;
    public static void sort(int[] nums){
        int N = nums.length;
        aux = new int[N];
        for (int sz = 1; sz < N; sz = sz+sz) {//sz子数组大小
            for (int left = 0; left <N-sz; left += sz+sz) {//left子数组索引
                merge(nums,left,left+sz-1,Math.min(left+sz+sz-1,N-1));
            }
        }
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
