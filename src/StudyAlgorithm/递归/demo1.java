package StudyAlgorithm.递归;

/**
 * 迷宫
 * @author dutu
 * @date 2021-05-13 14:56
 */
public class demo1 {
    public static void main(String[] args) {
        // 二位数组--->迷宫
        int[][] map = new int[8][7];
        // 1-->墙 0-->通路 2-->走过的 3-->走过的,死路
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板,1表示
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        setWay(map,1,1);
        //输出新的地图,小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean setWay(int[][] map, int i, int j) {
        if (map[6][1] == 2) return true;
        else {
            if (map[i][j] == 0){
                map[i][j] = 2;
                if (setWay(map,i+1,j)) return true;
                else if (setWay(map,i,j+1)) return true;
                else if (setWay(map,i-1,j)) return true;
                else if (setWay(map,i,j-1)) return true;
                else {
                    map[i][j] = 3;
                    return false;
                }

            }else {
                return false;
            }
        }

    }


}

