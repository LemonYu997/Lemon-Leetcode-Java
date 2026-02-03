package problems.c0easy.t3001t3500;

/**
 * 3206 交替组 I https://leetcode.cn/problems/alternating-groups-i/description/
 * 给你一个整数数组 colors ，它表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
 * colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
 * colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
 * 环中连续 3 块瓷砖的颜色如果是 交替 颜色（也就是说中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
 * 请你返回 交替 组的数目。
 * 注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
 *
 * 示例：
 * 输入1：colors = [1,1,1]
 * 输出1：0
 *
 * 输入2：colors = [0,1,0,0,1]
 * 输出2：3
 */
public class T3206 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int numberOfAlternatingGroups(int[] colors) {
        int ans = 0;
        int n = colors.length;
        // 每一个瓷砖都可以作为起始点
        for (int i = 0; i < n; i++) {
            int a = colors[i];
            int b;
            int c;
            if (i + 1 >= n) {
                b = colors[i + 1 - n];
            } else {
                b = colors[i + 1];
            }
            if (i + 2 >= n) {
                c = colors[i + 2 - n];
            } else {
                c = colors[i + 2];
            }
            // 判断之后的点是否为交替的
            if (a != b && b != c) {
                ans++;
            }
        }

        return ans;
    }


    /**
     * 官方解法：简化写法，使用 % 减少判断
     */
    public int numberOfAlternatingGroups1(int[] colors) {
        int n = colors.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i + 1) % n] && colors[(i + 1) % n] != colors[(i + 2) % n]) {
                ans++;
            }
        }
        return ans;
    }
}