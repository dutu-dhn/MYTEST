package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-29 13:45
 */
public class O11 {
    public static int minArray(int[] numbers) {

        for(int i =0; i<numbers.length-1; i++){
            if (numbers[i]>numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }

    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }


    public static void main(String[] args) {
        int[] numbers = new int[]{3,4,5,1,2};
        System.out.println(minArray(numbers));
    }
}
