package leetcode;

import java.util.Arrays;

public class L66 {
    //改进
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

    public static int[] plusOne(int[] digits) {
        //true表示有进位
        boolean jw = false;
        //digits数组索引
        int index = digits.length-1;
        //判断是否有进位,并把值传给jw
        if (digits[digits.length-1]==9){jw=true;}
        //若无进位,数组最后一个数加一返回
        else digits[digits.length-1]++;
        //存在进位则进行往前遍历判断前一个数字加上进位是否有进为有则继续
        while (jw){
            //解决第一个数字进位数组容量不够的情况
            if (index==0){
                digits = copy(digits);
                index++;
            }
            //令当前数字为0,前一个数字加一
            digits[index] = 0;
            //判断前一个数字是否有进位
            index--;
            if (digits[index]!=9){
                jw = false;
                digits[index]++;
            }
        }
        return digits;
    }

    public static int[] copy(int[] nums){
        int[] copy = new int[nums.length+1];
        for (int i = 1; i < copy.length; i++) {
            copy[i] = copy[i-1];
        }
        return copy;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9};


        System.out.println(Arrays.toString( plusOne(digits)));
    }
}
