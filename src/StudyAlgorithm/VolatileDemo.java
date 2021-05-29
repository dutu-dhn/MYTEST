package StudyAlgorithm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dutu
 * @date 2021-04-23 10:26
 */
public class VolatileDemo {
    public static void main(String[] args) {

//        MyData myData = new MyData();
//        for (int i = 1; i <= 20; i++) {
//            new Thread(() -> {
//                for (int j = 1; j <= 1000; j++) {
//                    myData.add();
//                    myData.addAtomicInteger();
//                }
//            },String.valueOf(i)).start();
//        }
//        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
//
//        while (Thread.activeCount() > 2){
//            Thread.yield();
//        }
//
//        System.out.println(Thread.currentThread().getName()+"\t --"+myData.number);
//        System.out.println(Thread.currentThread().getName()+"\t --"+myData.atomicInteger);


        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.changeNumber();
            System.out.println(Thread.currentThread().getName()+"\t 更改"+myData.number);

        },"AA").start();

        while (myData.number == 0){}
        System.out.println(Thread.currentThread().getName()+"\t "+myData.number);
    }
}
class MyData{
    volatile int number = 0;
    public void changeNumber(){
        this.number = 60;
    }
    public void add(){number++;}
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomicInteger(){atomicInteger.getAndIncrement();}
}