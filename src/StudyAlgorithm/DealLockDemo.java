package StudyAlgorithm;

import java.util.concurrent.TimeUnit;

/**
 * @author dutu
 * @date 2021-05-12 18:05
 */
public class DealLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        
        new Thread(new MyThread(lockA,lockB),"AAA").start();
        new Thread(new MyThread(lockB,lockA),"BBB").start();

    }
}
class MyThread implements Runnable{
    private String lockA;
    private String lockB;
    public MyThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"尝试获取"+lockB);

            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"尝试获取"+lockB);
            }
        }
    }
}