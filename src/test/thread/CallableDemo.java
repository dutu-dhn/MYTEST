package test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dutu
 * @date 2021-04-17 10:35
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask futureTask = new FutureTask(new Mythread2());

        new Thread(futureTask,"A").start();

        System.out.println(futureTask.get());

    }



}

class MyThread implements Runnable{

    @Override
    public void run() {

    }
}

class Mythread2 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*******");
        return 1024;
    }
}

