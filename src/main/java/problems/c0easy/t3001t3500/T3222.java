package problems.c0easy.t3001t3500;

/**
 * 3222 求出硬币游戏的赢家 https://leetcode.cn/problems/find-the-winning-player-in-coin-game/description/
 * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
 * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，
 * 玩家需要拿走价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
 * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
 *
 * 示例：
 * 输入1：x = 2, y = 7
 * 输出1："Alice"
 *
 * 输入2：x = 4, y = 11
 * 输出2："Bob"
 */
public class T3222 {
    /**
     * 自己实现：每人115，所以必须 75 * 1 + 10 * 4
     * 因此计算最多能来几轮，最后的那个人赢
     */
    public String winningPlayer(int x, int y) {
        int count = Math.min(x / 1, y / 4);
        return count % 2 == 0 ? "Bob" : "Alice";
    }
}
