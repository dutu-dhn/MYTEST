package leetcode;

public class L67 {
    public static String addBinary(String a, String b) {
        //结果
        String res = "";
        //进位
        boolean jw = false;
        int as = a.length();
        int bs = b.length();
        //把量=两个字符转补齐
        if (as>bs){
            for (int i = 0; i <as-bs; i++) {
                b = '0' + b;
            }
        }else if (as<bs){
            for (int i = 0; i <bs-as; i++) {
                a = '0' + a;
            }
        }

        for (int i = a.length()-1; i>=0 ; i--) {
            //同为1
            if (a.charAt(i)=='1'&&b.charAt(i)=='1'){
                //若上一次运算有进位,此位为一
                if (jw){
                    res = '1' + res;
                }//若上一次运算有进位,此位为0
                else {
                    res = '0' + res;
                }jw = true;
               // res = res +'0';
            //同为0
            }else if (a.charAt(i)=='0'&&b.charAt(i)=='0'){
                if (jw){
                    res = '1' + res;
                }else {
                    res = '0' + res;
                } jw = false;
            //一0一1
            }else {
                if (jw){
                    res = '0' + res;
                    jw = true;
                }else {
                    res = '1' + res;
                    jw = false;
                }
            }
        }
        if (jw){
            res = '1' + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a,b));
    }
}
