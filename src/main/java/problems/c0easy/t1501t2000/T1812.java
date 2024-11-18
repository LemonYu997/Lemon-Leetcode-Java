package problems.c0easy.t1501t2000;

/**
 * 1812 判断国际象棋棋盘中一个格子的颜色 https://leetcode.cn/problems/determine-color-of-a-chessboard-square/description/
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 *
 * 示例：
 * 输入1：coordinates = "a1"
 * 输出1：false
 *
 * 输入2：coordinates = "h3"
 * 输出2：true
 *
 * 输入3：coordinates = "c7"
 * 输出3：false
 */
public class T1812 {
    /**
     * 自己实现：横坐标和纵坐标之和为奇数时是白色，偶数为黑色，a 代表从 1 开始
     */
    public boolean squareIsWhite(String coordinates) {
        // 奇数时为白色，返回true
        return (coordinates.charAt(0) - 'a' + 1 + coordinates.charAt(1) - '0') % 2 == 1;
    }
}
