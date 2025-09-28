package problems.c0easy.t2501t3000;

/**
 * 2833 距离原点最远的点 https://leetcode.cn/problems/furthest-point-from-origin/description/
 * 给你一个长度为 n 的字符串 moves ，该字符串仅由字符 'L'、'R' 和 '_' 组成。
 * 字符串表示你在一条原点为 0 的数轴上的若干次移动。
 * 你的初始位置就在原点（0），第 i 次移动过程中，你可以根据对应字符选择移动方向：
 * 如果 moves[i] = 'L' 或 moves[i] = '_' ，可以选择向左移动一个单位距离
 * 如果 moves[i] = 'R' 或 moves[i] = '_' ，可以选择向右移动一个单位距离
 * 移动 n 次之后，请你找出可以到达的距离原点 最远 的点，并返回 从原点到这一点的距离 。
 *
 * 示例：
 * 输入1：moves = "L_RL__R"
 * 输出1：3
 *
 * 输入2：moves = "_R__LL_"
 * 输出2：5
 *
 * 输入3：moves = "_______"
 * 输出3：7
 */
public class T2833 {
    /**
     * 自己实现：统计各字符次数即可，最大距离为 count('_') + |count('L') - count('R')|
     */
    public int furthestDistanceFromOrigin(String moves) {
        int count0 = 0;
        int countL = 0;
        int countR = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == '_') {
                count0++;
            } else if (moves.charAt(i) == 'L') {
                countL++;
            } else {
                countR++;
            }
        }

        return count0 + Math.abs(countL - countR);
    }
}
