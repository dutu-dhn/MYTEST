package StudyAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dutu
 * @date 2021-04-15 20:01
 */
class ShareDataOne {
    private int number = 0;//初始值为零的一个变量
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number != 0){
                condition.await();
            }
            // 干活
            ++number;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public synchronized void decrement() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (number == 0){
                condition.await();
            }
            // 干活
            --number;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * * @Description:
 * 现在两个线程，
 * 可以操作初始值为零的一个变量，
 * 实现一个线程对该变量加1，一个线程对该变量减1，
 * 交替，来10轮。
 *
 * 笔记：Java里面如何进行工程级别的多线程编写
 * 1 多线程变成模板（套路）-----上
 * 1.1  线程    操作    资源类
 * 1.2  高内聚  低耦合
 * 2 多线程变成模板（套路）-----下
 * 2.1  判断
 * 2.2  干活
 * 2.3  通知
 * 3 防止虚假唤醒用while
 */
public class NotifyWaitDemoOne {
    public static void main(String[] args) {
        ShareDataOne shareDataOne = new ShareDataOne();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    shareDataOne.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    shareDataOne.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }
}
