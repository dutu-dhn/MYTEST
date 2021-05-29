package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dutu
 * @date 2020-11-25 16:20
 */
public class L119 {
    /**
     * 正着更新,给两个辅助变量
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        //结果数组
        List<Integer> res = new ArrayList<>();
        //本行第一个元素
        res.add(1);
        //if (rowIndex==0) {return res;}
        //0表示的是三角的第一行
        rowIndex++;
        //2-33行
        //本行的元素数量,也代表行数,第一行有一个元素依次类推
        int row = 2;
        //双辅助变量,pretemp表示前一个,temp表示第二个,两个变量保存数组内容平滑往后移动
        int pretemp = 1;
        int temp = 1;

        int i = 1;
        while (row<=rowIndex){
            //只有第二行往后才会进行
            if (row>2){
                for ( i = 1; i <=row-2 ; i++) {
                    res.set(i,pretemp+temp);
                    pretemp = temp;
                    if (i<row-2){temp = res.get(i+1);}
                }
            }
            //本行最后一个元素
            res.add(1);
            pretemp = res.get(0);
            temp = res.get(1);
            row++;
        }
        return res;
    }
    /**
     * 倒着更新,防止数值被改过
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow1(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2;i < dp.length;i++){
            for(int j = i - 1;j > 0;j--)
            {dp[j] = dp[j] + dp[j - 1];}
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    };

    public static void main(String[] args) {
        List<Integer> row = getRow1(5);
        System.out.println(row);
    }
}