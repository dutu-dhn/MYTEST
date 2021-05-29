package leetcode;

public class L1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //结果数组
        int[] res = new int[arr1.length];
        //结果数组索引
        int index = 0;
        //把arr1数组中的数按照arr2的顺序写入
        for (int i = 0;i<arr2.length;i++){
            for (int j = 0;j<arr1.length;j++){
                if (arr2[i]==arr1[j]){
                    res[index] = arr1[j];
                    arr1[j] = -1;
                    index++;
                }
            }
        }
        //结果数组中当前索引
        int i = index;
        //把arr1的剩余数据写入到结果数组
        for (int a : arr1) {
            if (a!=-1){
                res[index] = a;
                index++;
            }
        }
        //冒泡对剩余注入到res的数据进行大小排序
        maopao(i,res);

        return res;
    }

    public static int[] maopao(int index,int[] arr) {//int[] :返回值类型
        for (int i = index; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {//第i个与第i+1个比较再与第i+2个比较
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;//把最小的比出来放在最前面
                }// end if
            }// end for{}
        }// end for{ {} }
        return arr;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        //找出arr1数组中的最大值
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        //frequency数组的索引代表具体的值,frequency的值代表出现的次数
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }

        int[] ans = new int[arr1.length];
        int index = 0;
        //把arr2中有的数据从frequency取出放入ans,之后对frequency[index]清零,
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        //把剩余frequency中的数组写入到ans因剩余的值是作为索引,索引在顺序取出时,是按照顺序取出
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19,10};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] res = relativeSortArray(arr1,arr2);

        for (int i:res
             ) {
            System.out.print(i);
        }
    }
}
