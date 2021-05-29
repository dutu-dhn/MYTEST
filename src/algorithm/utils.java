package algorithm;

public class utils {
    public void swap(int nums[],int i,int j){
        int temp=0;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int compareTo(int a,int b){
        if (a>b) return 1;
        else if (a==b) return 0;
        else return -1;
    }
}
