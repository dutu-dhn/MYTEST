package StudyAlgorithm.排序;

import java.util.Arrays;

/**
 * 插入
 * @author dutu
 * @date 2021-05-14 16:00
 */
public class InsertSort {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {1,2,0,-5,3,4};
        System.out.println(Arrays.toString(array));
        insertSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array){

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j>0&&(array[j]<array[j-1]); j--) {
                int temp=0;
                temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }

    }
}
