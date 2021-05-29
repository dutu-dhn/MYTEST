package StudyAlgorithm;

import java.util.LinkedList;

/**
 * @author dutu
 * @date 2021-04-16 20:56
 */
public class ArrayQueue {

    public static void main(String[] args) {
        MyArrayQueue1 queue = new MyArrayQueue1(6);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.showAll();
        queue.add(6);
        queue.remove();
        System.out.println();
        queue.showAll();
        queue.add(6);
        System.out.println();
        queue.showAll();
        LinkedList<Integer> integers = new LinkedList<>();

    }
}

class MyArrayQueue{
    // 队列size
    private int maxSize;
    // 头
    private int headIndex = -1;
    // 尾
    private int footIndex = -1;

    private int[] array;

    public MyArrayQueue(int size){
        maxSize = size;
        array = new int[maxSize];

    }



    public boolean isEmpty(){
        return footIndex == headIndex;
    }

    public boolean isFull(){
        return footIndex == maxSize-1;
    }

    public int size(){
        return footIndex;
    }

    public void add(int element){
        if (isFull()){
            System.out.println("满");
            return;
        }else {
            array[++footIndex] = element;
        }
    }
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("空");
        }else {
            return array[headIndex+1];
        }
    }
    
    public void showAll(){
        if (isEmpty()){
            System.out.println("空");
        }else {
            for (int i = headIndex+1; i < footIndex+1; i++) {
                System.out.print(array[i]+" ");
            }
        }
    }
    public void remove(){
        headIndex++;
    }

}
class MyArrayQueue1{
    // 队列size
    private int maxSize;
    // 头
    private int headIndex = 0;
    // 尾
    private int footIndex = 0;

    private int[] array;

    public MyArrayQueue1(int size){
        maxSize = size;
        array = new int[maxSize];

    }

    public boolean isEmpty(){
        return footIndex == headIndex;
    }

    public boolean isFull(){
        return (footIndex+1)%maxSize == headIndex;
    }

    public int size(){
        return (footIndex+maxSize-headIndex)%maxSize;
    }

    public void add(int element){
        if (isFull()){
            System.out.println("满");
            return;
        }else {
            array[footIndex] = element;
            footIndex = (footIndex+1)%maxSize;
        }
    }
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("空");
        }else {
            return array[headIndex];
        }
    }

    public void showAll(){
        if (isEmpty()){
            System.out.println("空");
        }else {
            for (int i = headIndex; i < headIndex+size(); i++) {
                System.out.print(array[i%maxSize]+" ");
            }
        }
    }
    public int remove(){
        if (isEmpty()){
            throw new RuntimeException("空");
        }else {
            int temp = array[headIndex];
            headIndex = (headIndex+1)%maxSize;
            return temp;
        }
    }

}