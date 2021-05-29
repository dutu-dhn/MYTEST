package 剑指offer;

import java.util.Arrays;

/**
 * @author dutu
 * @date 2021-04-21 21:55
 */
public class O61 {

    public static void main(String[] args) {

    }
}
class Solution2 {
    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(nums[i] == 0) joker++; // 统计大小王数量
            else if(nums[i] == nums[i + 1]) return false; // 若有重复，提前返回 false
        }
        return nums[4] - nums[joker] < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }
}

