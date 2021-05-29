package StudyAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Description:
 * 多线程之间按顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮
 *
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sr.print5(i);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sr.print10(i);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sr.print15(i);
            }
        }, "CC").start();
    }
}
class ShareResource {
    private int number = 1;
    //1:A 2:B 3:C
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(int totalLoopNumber) {
        lock.lock();
        try {
            while (number != 1){
                c1.await();
            }
            for (int i = 1; i <=5; i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
            }
            number = 2;
            c2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            lock.unlock();
        }
    }
    public void print10(int totalLoopNumber) {
        lock.lock();
        try {
            while (number != 2){
                c2.await();
            }
            for (int i = 1; i <=10; i++)
            {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber: "+totalLoopNumber);
            }
            number = 3;
            c3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {

            lock.unlock();
        }
    }
    public void print15(int totalLoopNumber) {
        lock.lock();
        try {
            //1 判断
            while (number != 3) {
                //A 就要停止
                c3.await();
            }
            //2 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t totalLoopNumber: " + totalLoopNumber);
            }
            //3 通知
            number = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}