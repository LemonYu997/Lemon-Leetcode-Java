package problems.c0easy.t3001t3500;

/**
 * 3274 检查棋盘方格颜色是否相同 https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/description/
 * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
 * 以下是棋盘的参考图。
 * 如果这两个方格颜色相同，返回 true，否则返回 false。
 * 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
 *
 * 示例：
 * 输入1：coordinate1 = "a1", coordinate2 = "c3"
 * 输出1：true
 *
 * 输入2：coordinate1 = "a1", coordinate2 = "h3"
 * 输出2：false
 */
public class T3274 {
    /**
     * 自己实现：根据题意模拟
     * 观察棋盘，假设 abcdefgh 为 12345678，则横竖轴奇偶性相同时为黑色，反之为白色
     * 即判断两个坐标的xy坐标奇偶性是否一致即可
     */
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        boolean t1 = coordinate1.charAt(0) % 2 == coordinate1.charAt(1) % 2;
        boolean t2 = coordinate2.charAt(0) % 2 == coordinate2.charAt(1) % 2;
        return t1 == t2;
    }

    /**
     * 官方解法：规则计算
     * 如果两个格子之间行数的差值，与列数的差值，二者的和为偶数，就说明它们的颜色相同，否则颜色不同
     */
    public boolean checkTwoChessboards1(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0) - coordinate2.charAt(0) + coordinate1.charAt(1) - coordinate2.charAt(1)) % 2 == 0;
    }
}
