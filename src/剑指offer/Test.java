package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-18 19:33
 */
public class Test {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 40; i++) ticket.SaleTicket();
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 40; i++) ticket.SaleTicket();
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 40; i++) ticket.SaleTicket();
            }
        },"C").start();

        new Thread(new Runnable() {
             @Override
             public void run() {

              }
        },"").start();




    }

}

class Ticket{
    private int size = 30;

    public synchronized void SaleTicket(){
        if (size>0){
            size--;
            System.out.println(Thread.currentThread().getName()+"拿到票子--"+"剩余--"+size);
        }

    }
}

