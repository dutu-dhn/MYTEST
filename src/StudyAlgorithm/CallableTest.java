package StudyAlgorithm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dutu
 * @date 2021-05-11 20:03
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallableThread myCallableThread = new MyCallableThread();

        FutureTask futureTask = new FutureTask<>(myCallableThread);

        new Thread(futureTask,"AA").start();
        // 无法使用,还是同一个,需要新建一个FutureTask futureTask1 = new FutureTask<>(myCallableThread);
        // new Thread(futureTask,"BB").start();

        System.out.println(futureTask.get());

        System.out.println(Thread.currentThread().getName()+"\t main---------");

    }
}

class MyCallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t come in Callable");
        return 1024;
    }
}
