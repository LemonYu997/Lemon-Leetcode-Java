package problems.c0easy.t2501t3000;

/**
 * 2660 保龄球游戏的获胜者 https://leetcode.cn/problems/determine-the-winner-of-a-bowling-game/description/
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * 玩家的得分是其 n 轮价值的总和。
 * 返回
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 *
 * 示例：
 * 输入1：player1 = [5,10,3,2], player2 = [6,5,7,3]
 * 输出1：1
 *
 * 输入2：player1 = [3,5,7,6], player2 = [8,10,10,2]
 * 输出2：2
 *
 * 输入3：player1 = [2,3], player2 = [4,1]
 * 输出3：0
 *
 * 输入4：player1 = [1,1,1,10,10,10,10], player2 = [10,10,10,10,1,1,1]
 * 输出4：2
 */
public class T2660 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0;
        int score2 = 0;

        for (int i = 0; i < player1.length; i++) {
            if ((i > 0 && player1[i - 1] == 10) || (i > 1 && player1[i - 2] == 10)) {
                score1 += player1[i] * 2;
            } else {
                score1 += player1[i];
            }
        }

        for (int i = 0; i < player2.length; i++) {
            if ((i > 0 && player2[i - 1] == 10) || (i > 1 && player2[i - 2] == 10)) {
                score2 += player2[i] * 2;
            } else {
                score2 += player2[i];
            }
        }

        if (score1 == score2) {
            return 0;
        }
        return score1 > score2 ? 1 : 2;
    }
}
