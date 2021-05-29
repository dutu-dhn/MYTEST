package algorithm;

import java.util.Arrays;

//快排
public class Quick_Sort {

    public static void sort(int[] a){
        //sort(a,0,a.length-1);
        sort3way(a,0,a.length-1);
    }

    public static void sort(int[] a,int left,int right){
        if (right<=left) return;
        int j = partition(a, left, right);
        sort(a, left, j-1);
        sort(a,j+1,right);
    }
//三向切分
    public static void sort3way(int[] a,int left,int right){
        utils utils = new utils();
        if (right<=left) return;
        int lt = left,i = left+1,gt = right;
        int v = a[left];
        while(i<=gt){
            int cmp = utils.compareTo(a[i],v);
            if (cmp<0) utils.swap(a,lt++,i++);
            else if (cmp>0) utils.swap(a,i,gt--);
            else i++;
        }
        sort3way(a,left,lt-1);
        sort3way(a,gt+1,right);
    }

    //快排的切分
    private static int partition(int[] a,int left,int right){
        utils utils = new utils();
        int i = left,j = right+1;
        int v = a[left];
        while(true){
            while(a[++i]<v) if (i==right) break;
            while (v<a[--j]) if (j==left) break;
            if ( i>=j) break;
            utils.swap(a,i,j);
        }
        utils.swap(a,left,j);
        return j;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,8,6,0,7,3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
