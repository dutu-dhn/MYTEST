package test;

//定长数组实现队列的抽象,扩展实现使用调整数组的方法突破大小限制
public class demo09 implements demo09Queue {
    //队列初始大小
    public int size = 4;
    //数组抽象化实现队列
    public String[] queue= new String[size];;
    //队列元素数量
    private int N = 0;
    //构建器
    public demo09() {
    }
    @Override
    public boolean add(String e) {
        //判断队列中的元素数量N与队列的大小,>=一半的size,扩大队列size
        if (size/2==N){
            size = size*2;
            String[] temp = new String[size];
            for (int i = 0;i<N;i++){
                temp[i] = queue[i];
            }
            queue = temp;
            temp = null;
        }
        queue[N] = e;
        N++;
        return true;
    }

    @Override
    public String remove() {
        String[] temp = new String[size];
        String deleteElement = queue[0];
        for (int i = 0;i<N-1;i++){
            temp[i] = queue[i+1];
        }
        queue = temp;
        temp = null;
        return deleteElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public static void main(String[] args) {
        demo09 d = new demo09();
        d.add("1");
        System.out.println("size"+d.size);
        d.add("2");
        System.out.println("size"+d.size);
        d.add("3");
        System.out.println("size"+d.size);
        d.add("4");
        System.out.println("size"+d.size);
        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());
        System.out.println(d.remove());

    }
}
