package test;

/**
 * @author dutu
 * @date 2021-05-15 20:47
 */
public class StackOverflowDemo {

    public static void main(String[] args) {
        stackOverflow();
    }

    private static void stackOverflow() {
        stackOverflow();
    }
}
