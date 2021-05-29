package StudyAlgorithm.排序;

import java.util.Arrays;

/**
 * 选择
 * @author dutu
 * @date 2021-05-14 15:41
 */
public class SelectSort {
    public static void main(String[] args) {

        SelectSort selectSort = new SelectSort();
        int[] array = {1,2,0,-5,3,4};
        System.out.println(Arrays.toString(array));
        selectSort.sort(array);
        System.out.println();
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int min = array[i];

            for (int j = i+1; j < array.length; j++) {
                if (min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i){
                array[minIndex] = array[i];
                array[i] = min;
            }



        }
    }
}
