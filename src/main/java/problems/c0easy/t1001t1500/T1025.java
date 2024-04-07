package problems.c0easy.t1001t1500;

/**
 * 1025 除数博弈 https://leetcode.cn/problems/divisor-game/description/
 * 共有A、B两个玩家。轮流行动，A先开始。
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 * 1、选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 2、用 n - x 替换黑板上的数字 n 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有 A 胜利的时候返回 true。
 *
 * 示例：
 * 输入1：n = 2
 * 输出1：true
 *
 * 输入2：n = 3
 * 输出2：false
 */
public class T1025 {
    public static void main(String[] args) {
        divisorGame(4);
    }

    /**
     * 错误，勿用！！！
     * 自己实现：根据题意模拟
     * 每次选取 n 的最大因数（除了n）作为选择的 x，持续到 n = 1为止
     * 当轮数为奇数时，即 A 获胜，返回 true
     */
    public static boolean divisorGame(int n) {
        int i = 0;  // 游戏轮数
        while (n > 1) {
            // 找到 n 以下的最大因数
            int x = n - 1;
            while (n % x != 0) {
                x--;
            }
            // 更新 n 和轮数
            n = n - x;
            i++;
        }
        // 如果 i 是奇数，说明 A 获胜
        return i % 2 != 0;
    }

    /**
     * 官方解法：
     * n = 1时，A 败
     * n = 2时，A 取 1，B 败
     * n = 3时，A 取 1，B 取 1，A 败
     * n = 4时，A 取 1，余 3, 根据上述可推得 B 败
     * ...
     * 可推得，n 为奇数 A 必败
     */
    public boolean divisorGame1(int n) {
        return n % 2 == 0;
    }

    /**
     * 官方解法2：动态规划
     */
    public boolean divisorGame2(int n) {
        boolean[] f = new boolean[n + 5];
        f[1] = false;
        f[2] = true;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
