package problems.c0easy.t3001t3500;

/**
 * 3232 判断是否可以赢得数字游戏 https://leetcode.cn/problems/find-if-digit-game-can-be-won/description/
 * 给你一个 正整数 数组 nums。
 * Alice 和 Bob 正在玩游戏。在游戏中，Alice 可以从 nums 中选择所有个位数 或 所有两位数，
 * 剩余的数字归 Bob 所有。如果 Alice 所选数字之和 严格大于 Bob 的数字之和，则 Alice 获胜。
 * 如果 Alice 能赢得这场游戏，返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,10]
 * 输出1：false
 *
 * 输入2：nums = [1,2,3,4,5,14]
 * 输出2：true
 *
 * 输入3：nums = [5,5,5,25]
 * 输出3：true
 */
public class T3232 {
    /**
     * 自己实现：模拟，只有 个位数之和 != 两位数之和时，Alice 才会赢
     */
    public boolean canAliceWin(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for (int num : nums) {
            if (num >= 10) {
                sum2 += num;
            } else {
                sum1 += num;
            }
        }
        return sum1 != sum2;
    }
}
