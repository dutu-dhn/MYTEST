package leetcode;

/**
 * @author dutu
 * @date 2020-11-27 14:11
 */
public class L125 {
    public static boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        int preindex = 0;
        int index = s.length()-1;
        char pretemp = s.charAt(preindex);
        char temp = s.charAt(index);
        while (preindex<=index){
            pretemp = s.charAt(preindex);
            temp = s.charAt(index);
            if (pretemp<=57&&pretemp>=48||pretemp<=122&&pretemp>=97){

            }else preindex++;

            if (temp<=57&&temp>=48||temp<=122&&temp>=97){

            }else index--;
            if ((pretemp<=57&&pretemp>=48||pretemp<=122&&pretemp>=97)&&(temp<=57&&temp>=48||temp<=122&&temp>=97)){
                System.out.print(preindex+"--"+pretemp+"---");
                System.out.println(index+"--"+temp);
                if (pretemp!=temp) return false;
                preindex++;
                index--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "Abba";
        s = s.toLowerCase();
        System.out.println(isPalindrome(s));


    }
}
