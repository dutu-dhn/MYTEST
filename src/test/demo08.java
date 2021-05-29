package test;

//编写一个可迭代的Stack,含有静态copy方法,接受一个字符串的栈作为参数,并返回一个改栈的副本
import java.util.Iterator;

public class demo08<Item> implements Iterable<Item> {
    private int size;
    private Node first;

    public boolean isEmpty(){return first==null;}

    public int size(){ return size;}

    public void push(Item item){
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        size++;
    }
    public Item pop(){
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }
    public static <Item> demo08<Item> copy(demo08<Item> d){
        Iterator<Item> it=d.iterator();
        demo08<Item> result=new demo08<Item>();
        demo08<Item> temp=new demo08<Item>();
        while(it.hasNext())
        {
            temp.push(it.next());
        }
        it=temp.iterator();
        while(it.hasNext())
        {
            result.push(it.next());
        }
        return result;
    }
    private class Node{
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current=first;
        public boolean hasNext()
        {
            return current!=null;
        }
        public void remove() {}
        public Item next()
        {
            Item item=current.item;
            current=current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        demo08<String> d = new demo08<>();
        d.push("1");
        demo08<String> copy = copy(d);
        System.out.println(copy.size);

    }
}
