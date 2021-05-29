package test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendSMS");
        sendEmail();
    }
    public synchronized void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendEmael");
    }

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke get");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke get");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class MyLock {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     phone.sendSMS();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
             }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.sendSMS();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();

        Thread t3 = new Thread(phone, "t3");
        t3.start();

        Thread t4 = new Thread(phone, "t4");
        t4.start();

    }
}
