package leetcode;

/**
 * @author dutu
 * @date 2020-11-30 20:25
 */
public class L167 {
    public static int[] twoSum(int[] numbers, int target) {
        //结果数组
        int[] res = new int[2];
        //输入数组为空直接返回res
        if (numbers.length==0) return res;
        //前指针
        int preindex = 0;
        //后指针,若最后一个数小于目标数,则后指针为numbers.length-1,否则二分查找找到目标值所在位置(不相等则是后一个位置)
        int lastindex =numbers[numbers.length-1]<=target?numbers.length-1: binarySearch(numbers,target);
        //前加后等于目标值,则返回
        //前加后>目标值.则后指针前移
        //前指针<目标值,则前指针后移
        while (preindex<=lastindex){
            if ((numbers[preindex]+numbers[lastindex])==target){
                res[0] = preindex+1;
                res[1] = lastindex+1;
                return res;
            }else if ((numbers[preindex]+numbers[lastindex])>target){
                lastindex--;
            }else {
                preindex++;
                //lastindex--;
            }
        }

        return res;
    }

    public static int binarySearch(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
             mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid==0?1:mid;
        }
        return mid==0?1:mid;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,24,50,79,88,150,345};
        System.out.println(binarySearch(nums,-1));

        for (int i : twoSum(nums, 200)) {
            System.out.println(i);
        }

    }
}
