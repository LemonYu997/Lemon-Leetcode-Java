package problems.c0easy.t3001t3500;

import java.util.List;

/**
 * 3248 矩阵中的蛇 https://leetcode.cn/problems/snake-in-matrix/description/
 * 大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。
 * 矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
 * 蛇从单元格 0 开始，并遵循一系列命令移动。
 * 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，
 * 其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
 * 返回执行 commands 后蛇所停留的最终单元格的位置。
 *
 * 示例：
 * 输入1：n = 2, commands = ["RIGHT","DOWN"]
 * 输出1：3
 *
 * 输入2：n = 3, commands = ["DOWN","RIGHT","UP"]
 * 输出2：1
 */
public class T3248 {
    /**
     * 自己实现：根据题意模拟，计算结束时的索引位置即可
     */
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (String command : commands) {
            if ("UP".equals(command)) {
                i--;
            }
            if ("DOWN".equals(command)) {
                i++;
            }
            if ("LEFT".equals(command)) {
                j--;
            }
            if ("RIGHT".equals(command)) {
                j++;
            }
        }

        return i * n + j;
    }

    /**
     * 官方解法：简化判断
     */
    public int finalPositionOfSnake1(int n, List<String> commands) {
        int ans = 0;
        for (String command : commands) {
            if (command.charAt(0) == 'U') {
                ans -= n;
            } else if (command.charAt(0) == 'D') {
                ans += n;
            } else if (command.charAt(0) == 'L') {
                ans--;
            } else {
                ans++;
            }
        }
        return ans;
    }
}