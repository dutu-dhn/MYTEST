package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dutu
 * @date 2021-03-17 9:13
 */
public class M0101 {
    public static boolean isUnique(String astr) {
        Map map = new HashMap();
        for (int i = 0;i<astr.length();i++){
            char c = astr.charAt(i);
            if (map.get(c) == null){
                map.put(c,1);
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String astr = "";
        System.out.println(isUnique(astr));
    }

}
