package StudyAlgorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dutu
 * @date 2021-05-11 21:23
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);//假设银行5个窗口
        ExecutorService threadPool2 = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i < 10; i++) {//10个人来办业务
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool1.shutdown();
        }




    }
}
