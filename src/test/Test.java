package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class Myache{
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    ArrayList arrayList = new ArrayList<Integer>();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t ---写入");
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t ---写入完成");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t 读取");
            try { TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"\t 读取完成-"+map.get(key));
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class User
{
    private Integer id;
    private String  userName;
    private int     age;
}

class MyTask extends RecursiveTask<Integer> {
    private static final Integer ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if((end - begin)<=ADJUST_VALUE){
            for(int i =begin;i <= end;i++){
                result = result + i;
            }
        }else{
            int middle = (begin + end)/2;
            MyTask task01 = new MyTask(begin,middle);
            MyTask task02 = new MyTask(middle+1,end);
            task01.fork();
            task02.fork();
            result =  task01.join() + task02.join();
        }


        return result;
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Lock lock = new ReentrantLock();
        lock.lockInterruptibly();


/*        MyTask myTask = new MyTask(0,100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        forkJoinPool.shutdown();
        String a = "a";
        String b = "a";
        a.equals(b);*/
        String name = "";
        if (name!=null && !name.equals("")) {
            System.out.println("&&");
        }

        if (name!=null & !name.equals("")) {
            System.out.println("&");
        }


















//
//        User u1 = new User(11,"a",23);
//        User u2 = new User(12,"b",24);
//        User u3 = new User(13,"c",22);
//        User u4 = new User(14,"d",28);
//        User u5 = new User(16,"e",26);
//
//        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
//
//        list.stream().filter(p -> {
//            return p.getId() % 2 == 0;
//        }).filter(p -> {
//            return p.getAge() > 24;
//        }).map(f -> {
//            return f.getUserName().toUpperCase();
//        }).sorted((o1, o2) -> {
//            return o2.compareTo(o1);
//        }).limit(1).forEach(System.out::println);














//        //R apply(T t);函数型接口，一个参数，一个返回值
//        Function<String, String> function = t -> {return "123";};
//        function.apply("abc");
//
//        //boolean test(T t);断定型接口，一个参数，返回boolean
//        Predicate<String> predicate = t -> {return t.isEmpty();};
//        predicate.test("123");
//
//        // void accept(T t);消费型接口，一个参数，没有返回值
//        Consumer<String> consumer = t -> { System.out.println(t); };
//        consumer.accept("123");
//
//        //T get(); 供给型接口，无参数，有返回值
//        Supplier<String> supplier = () -> {return "123";};
//        supplier.get();


















//        ExecutorService mypool = new ThreadPoolExecutor(
//                2,
//                5,
//                2L,
//                TimeUnit.SECONDS,
//                new LinkedBlockingQueue<>(3),
//                Executors.defaultThreadFactory(),
//                //new ThreadPoolExecutor.DiscardPolicy()
//                //new ThreadPoolExecutor.CallerRunsPolicy()
//                //new ThreadPoolExecutor.DiscardOldestPolicy()
//                new ThreadPoolExecutor.AbortPolicy());
//
//        try {
//            for (int i = 1; i < 10; i++) {
//                mypool.execute(()->{
//                    System.out.println(Thread.currentThread().getName()+"\t 处理任务");
//
//                });
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            mypool.shutdown();
//        }


    }





    /*{
        Myache myache = new Myache();

        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myache.put(temp+"",temp+"");
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myache.get(temp+"");
            }, String.valueOf(i)).start();
        }


        Semaphore semaphore = new Semaphore(3);//模拟资源类,有三个

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"占用");

                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"释放");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }


        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () ->{
            System.out.println("*********");
        });

        for (int i = 1; i <=7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }



//        for (int i = 1; i <= 6; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName()+"离开");
//            },""+i).start();
//        }
//        System.out.println("main离开");

        CountDownLatch countDownLatch = new CountDownLatch(6);
        // main主线程必须要等前面6个线程完成全部工作后，自己才能开始
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName()+"离开");
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("main离开");





       // Map<String, String> map = new HashMap<>();
        // Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
//       Map<String, String> map = new ConcurrentHashMap<>();
//        for (int i = 1; i <= 30; i++) {
//            new Thread(() -> {
//                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,9));
//                System.out.println(map);
//            },String.valueOf(i)).start();
//        }
//
//        Queue queue = new LinkedList();



*//*        // Set<String> set = new HashSet<>();

        // Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,9));
                System.out.println(set);
            }).start();
        }*//*



      // List<String> list = new Vector<>();

        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        //List<String> list =new CopyOnWriteArrayList<>();
        //List<String> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0,9));
//                System.out.println(list);
//            }).start();
//        }
    }*/
}

