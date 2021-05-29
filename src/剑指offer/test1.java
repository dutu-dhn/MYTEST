package 剑指offer;


/**
 * @author dutu
 * @date 2021-03-18 20:38
 */
public class test1 {

    public test1() {
    }



    public static test1 t1 = new test1();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {

        test1 t2 = new test1();
    }

}
