package test;

/**
 * @author dutu
 * @date 2021-05-17 15:50
 */
public class M1 {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;

        i = i++;
        j = ++j;
        System.out.println(i);
        System.out.println(j);
    }
}
