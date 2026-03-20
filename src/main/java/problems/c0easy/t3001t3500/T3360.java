package problems.c0easy.t3001t3500;

/**
 * 3360 移除石头游戏 https://leetcode.cn/problems/stone-removal-game/description/
 * Alice 和 Bob 在玩一个游戏，他们俩轮流从一堆石头中移除石头，Alice 先进行操作。
 * Alice 在第一次操作中移除 恰好 10 个石头。
 * 接下来的每次操作中，每位玩家移除的石头数 恰好 为另一位玩家上一次操作的石头数减 1 。
 * 第一位没法进行操作的玩家输掉这个游戏。
 * 给你一个正整数 n 表示一开始石头的数目，如果 Alice 赢下这个游戏，请你返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：n = 12
 * 输出1：true
 *
 * 输入2：n = 1
 * 输出2：false
 */
public class T3360 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean canAliceWin(int n) {
        // A 先手
        boolean flag = false;
        for (int i = 10; i > 0; i--) {
            if (n >= i) {
                n -= i;
                flag = !flag;
            } else {
                break;
            }
        }
        return flag;
    }

    /**
     * 官方解法：优化写法
     */
    public boolean canAliceWin1(int n) {
        int pick = 10;
        while (n >= pick) {
            n -= pick;
            pick--;
        }
        // 判断进行了几轮了 A先手，所以奇数轮是 A 胜
        return (10 - pick) % 2 > 0;
    }
}