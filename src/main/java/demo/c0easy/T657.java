package demo.c0easy;

/**
 * 657 机器人能否回到原点 https://leetcode.cn/problems/robot-return-to-origin/
 * 二维平面，一个机器人从[0,0]开始移动，输入移动数组moves[i]
 * 只会进行如下移动 R（右）、L（左）、U（上）、D（下）
 * 判断机器人经过移动后是否回到了原点
 *
 * 示例：
 * 输入1：moves = "UD"
 * 输出1：true
 *
 * 输入2：moves = "LL"
 * 输出2：false
 */
public class T657 {
    /**
     * 自己实现：用两个int表示坐标，求移动后是否都为0即可
     */
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {
            char m = moves.charAt(i);
            if (m == 'L') {
                x--;
            }
            if (m == 'R') {
                x++;
            }
            if (m == 'U') {
                y++;
            }
            if (m == 'D') {
                y--;
            }
        }

        return x == 0 && y == 0;
    }
}
