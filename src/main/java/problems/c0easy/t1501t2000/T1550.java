package problems.c0easy.t1501t2000;

/**
 * 1550 存在连续三个奇数的数组 https://leetcode.cn/problems/three-consecutive-odds/description/
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
 * 如果存在，请返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：arr = [2,6,4,1]
 * 输出1：false
 *
 * 输入2：arr = [1,2,34,3,4,5,7,23,12]
 * 输出2：true
 */
public class T1550 {
    /**
     * 自己实现：遍历一次，统计连续出现的奇数次数
     */
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
}
