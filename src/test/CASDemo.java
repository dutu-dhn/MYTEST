package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dutu
 * @date 2021-04-29 13:01
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2021)+"\t --"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,20)+"\t --"+atomicInteger.get());
        atomicInteger.getAndIncrement();

    }
}
