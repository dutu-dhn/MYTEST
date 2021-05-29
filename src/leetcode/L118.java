package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dutu
 * @create 2020-11-25 15:30
 */
public class L118 {
    public static List<List<Integer>> generate(int numRows) {
        //结果数组
        List<List<Integer>> ys = new ArrayList<>();
        //判0
        if (numRows == 0) {
            return ys;
        }
        //当前三角行数,即结果数组的size
        int rows = 0;
        while (rows!=numRows){
            //存一行的数
            List<Integer> row = new ArrayList<>();
            //第一个和最后一个数字为1
            if (rows+1==1){row.add(1);}
            else if (rows+1==2){row.add(1);row.add(1);}
            else{
                //拿到上一行的数
                List<Integer> integers = ys.get(ys.size()-1);
                //遍历取上一行的数按照规则加入到这一行
                for (int i = 0; i <= integers.size(); i++) {
                    if (i==0||i==integers.size()) {row.add(1);}
                    else{
                        row.add(integers.get(i)+integers.get(i-1));
                    }
                }
            }
            //把这一行数组加入到结果数组
            ys.add(row);
            //下一行
            rows++;
        }
        return ys;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return triangle;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }

        return triangle;
    }


    public static void main(String[] args) {
        List<List<Integer>> generate = generate(3);
        System.out.println(generate);
    }
}
