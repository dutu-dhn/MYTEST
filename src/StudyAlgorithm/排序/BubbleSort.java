package StudyAlgorithm.排序;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author dutu
 * @date 2021-05-14 14:51
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,9,0,-2,5,3};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);

    }

    public void sort(int[] array){
        int temp = 0;

        // 优化
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]){
                    flag = true;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            System.out.println("第"+i+"次排序");
            System.out.println(Arrays.toString(array));
            if (flag == false) break;
            else flag = false;
        }
    }
}
