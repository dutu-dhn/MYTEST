package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dutu
 * @date 2021-05-10 20:30
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) {


        Mysource resource = new Mysource(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            try {
                resource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "生产者").start();
        new Thread(() -> {
            try {
                resource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "消费者1").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("5s时间到，停止生产.");
        resource.stop();
    }
}
class Mysource{
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public Mysource(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.getClass().getName());
        this.blockingQueue = blockingQueue;
    }



    public void myProd() throws InterruptedException {
        String data = null;
        boolean resultValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet() + "";
            resultValue = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if (resultValue){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列"+data+" 成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列"+data+" 失败");
            }
            Thread.sleep(1000);
        }
        System.out.println("收到信号,停止生产--"+ Thread.currentThread().getName() +"--生产结束");
    }
    public void myConsumer() throws InterruptedException {
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2,TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没取到,停止消费");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t队列取出"+result+"成功");
        }
    }
    public void stop(){
        this.FLAG = false;
    }
}