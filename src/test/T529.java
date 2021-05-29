package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dutu
 * @date 2021-05-29 9:33
 */
public class T529 {
    public static void main(String[] args) {

       // HashMap hashMap = new HashMap();
        ConcurrentHashMap hashMap = new ConcurrentHashMap<>();
        hashMap.put("不只Java-1", 1);
        hashMap.put("不只Java-2", 2);
        hashMap.put("不只Java-3", 3);
        hashMap.put("不只Java-3", 4);

        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            hashMap.put("下次循环会抛异常", 4);
            System.out.println("此时 hashMap 长度为" + hashMap.size());
        }


    }
}
