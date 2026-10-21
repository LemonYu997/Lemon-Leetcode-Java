package problems.c0easy.t4001t4500;

/**
 * 4061 皇后到达目标格子的最少移动步数 https://leetcode.cn/problems/minimum-queen-moves-to-reach-target/description/
 * 一个 8 x 8 的空棋盘，其行和列的下标从 1 开始。
 * 给你一个数组 source = [sr, sc] 表示 皇后 的初始位置，以及一个数组 target = [tr, tc] 表示目标位置。
 * 在一步移动中，皇后可以在棋盘范围内，沿着单条 行 、 列 或 对角线 移动一个或多个方格。
 * 返回皇后移动到 恰好 落在 target 位置所需的 最小 移动次数。
 *
 * 输入1：source = [8,1], target = [1,8]
 * 输出1：1
 *
 * 输入2：source = [4,2], target = [1,3]
 * 输出2：2
 *
 * 输入3：source = [1,1], target = [1,1]
 * 输出3:0
 */
public class T4061 {
    /**
     * 自己实现：根据题意，皇后到棋盘任意一点最多也就需要2次，所以根据情况判断即可
     */
    public int minQueenMoves(int[] source, int[] target) {
        // 目标点即原点
        if (target[0] == source[0] && target[1] == source[1]) {
            return 0;
        }
        // 目标点在行、列、对角线上
        if (target[0] == source[0]
                || target[1] == source[1]
                || target[0] + target[1] == source[0] + source[1]
                || target[0] - target[1] == source[0] - source[1]) {
            return 1;
        }
        return 2;
    }
}
