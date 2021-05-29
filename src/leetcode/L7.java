package leetcode;

public class L7 {
    public static int reverse(int x) {
        try {
            String temp = "";
            //正负号
            if (x>0){
                while(x>0){
                    int t = x%10;
                    x = x/10;
                    temp = temp+t;
                    System.out.println(temp);
                }return Integer.parseInt(temp);
            }else if (x<0){
                x = x*(-1);
                while(x>0){
                    int t = x%10;
                    x = x/10;
                    temp = temp+t;
                    System.out.println(temp);
                }return Integer.parseInt(temp)*(-1);
            }else {return 0;}
        }catch (Exception E){
            return 0;
        }

    }

    public static int reverse1(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }


    public static void main(String[] args) {

        //System.out.println(reverse(122222222));
        System.out.println(reverse1(123));
    }
}
