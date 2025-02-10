package problems.c0easy.t2001t2500;

/**
 * 2103 环和杆 https://leetcode.cn/problems/rings-and-rods/description/
 * 总计有 n 个环，环的颜色可以是红、绿、蓝中的一种。这些环分别穿在 10 根编号为 0 到 9 的杆上。
 * 给你一个长度为 2n 的字符串 rings ，表示这 n 个环在杆上的分布。rings 中每两个字符形成一个 颜色位置对 ，用于描述每个环：
 * 第 i 对中的 第一个 字符表示第 i 个环的 颜色（'R'、'G'、'B'）。
 * 第 i 对中的 第二个 字符表示第 i 个环的 位置，也就是位于哪根杆上（'0' 到 '9'）。
 * 例如，"R3G2B1" 表示：共有 n == 3 个环，红色的环在编号为 3 的杆上，
 * 绿色的环在编号为 2 的杆上，蓝色的环在编号为 1 的杆上。
 * 找出所有集齐 全部三种颜色 环的杆，并返回这种杆的数量。
 *
 * 示例：
 * 输入1：rings = "B0B6G0R6R0R6G9"
 * 输出1：1
 *
 * 输入2：rings = "B0R0G0R9R0B0G0"
 * 输出2：1
 *
 * 输入3：rings = "G4"
 * 输出3：0
 */
public class T2103 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countPoints(String rings) {
        int[][] temp = new int[10][3];
        int ans = 0;

        for (int i = 0; i < rings.length(); i += 2) {
            char c = rings.charAt(i);
            int a = rings.charAt(i + 1) - '0';

            if (c == 'R') {
                temp[a][0] = 1;
            } else if (c == 'G') {
                temp[a][1] = 1;
            } else {
                temp[a][2] = 1;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (temp[i][0] + temp[i][1] + temp[i][2] == 3) {
                ans++;
            }
        }

        return ans;
    }
}
