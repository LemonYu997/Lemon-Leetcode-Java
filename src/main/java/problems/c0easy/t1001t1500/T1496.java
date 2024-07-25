package problems.c0easy.t1001t1500;

import java.util.HashSet;
import java.util.Set;

/**
 * 1496 判断路径是否相交 https://leetcode.cn/problems/path-crossing/description/
 * 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，
 * 分别表示向北、向南、向东、向西移动一个单位。
 * 你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
 *
 * 如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，
 * 请返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：path = "NES"
 * 输出1：false
 *
 * 输入2：path = "NESWW"
 * 输出2：true
 */
public class T1496 {
    /**
     * 官方解法：使用哈希表存储走过的路径
     * 使用 hash 函数 f(x,y)=x×20001+y 控制 y 的取值范围在 [−10 ^ 4, 10 ^4] 内
     */
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<Integer>();
        int x = 0;
        int y = 0;
        set.add(getHash(x, y));

        int len = path.length();
        for (int i = 0; i < len; i++) {
            char dir = path.charAt(i);
            switch (dir) {
                case 'N':
                    x--;
                    break;
                case 'S':
                    x++;
                    break;
                case 'W':
                    y--;
                    break;
                case 'E':
                    y++;
                    break;
            }
            int temp = getHash(x, y);
            if (!set.add(temp)) {
                return true;
            }
        }

        return false;
    }

    public int getHash(int x, int y) {
        return x * 20001 + y;
    }
}
