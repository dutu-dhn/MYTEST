package test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author dutu
 * @date 2021-05-01 7:54
 */
public class ABADemo {
   static int a = 0;
    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a",null);
        a++;
        MyUser z3 = new MyUser("z3", 22);
        MyUser l4 = new MyUser("l4", 25);

        AtomicReference<MyUser> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.toString());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.toString());

        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
class MyUser{
    String name;
    int age;
}
abstract class tt1{
    int a = 0;
}
interface tt2{
    int a = 0;
}