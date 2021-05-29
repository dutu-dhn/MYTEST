package 剑指offer;

/**
 * @author dutu
 * @date 2021-03-23 20:32
 */
public class O05 {

    public static void main(String[] args) {
        String s = " ";
        System.out.println(replaceSpace(s));
        System.out.println();
        System.out.println(s.replace(" ", "%20"));
    }


    public static String replaceSpace(String s) {
        if (!s.contains(" ")){
            return s;
        }

        String result = "";
        String temp;
        String tar = "%20";
        for (int i = 0;i<s.length();i++){
            temp = s.substring(i,i+1);
            if (temp.equals(" ")){
                result = result + tar;
            }else {
                result = result + temp;
            }
        }
        return result;
    }


}
