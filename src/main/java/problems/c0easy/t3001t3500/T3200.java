package problems.c0easy.t3001t3500;

/**
 * 3200 三角形的最大高度 https://leetcode.cn/problems/maximum-height-of-a-triangle/description/
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，
 * 满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
 * 返回可以实现的三角形的 最大 高度。
 *
 * 示例：
 * 输入1：red = 2, blue = 4
 * 输出1：3
 *
 * 输入2：red = 2, blue = 1
 * 输出2：2
 *
 * 输入3：red = 1, blue = 1
 * 输出3：1
 *
 * 输入4：red = 10, blue = 1
 * 输出4：2
 */
public class T3200 {
    /**
     * 自己实现：根据题意模拟
     */
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(maxHeight(red, blue), maxHeight(blue, red));
    }

    public int maxHeight(int x, int y) {
        int i = 1;
        do {
            if (i % 2 == 1) {
                x -= i;
                if (x < 0) {
                    return i - 1;
                }
            } else {
                y -= i;
                if (y < 0) {
                    return i - 1;
                }
            }
            i++;
        } while (true);
    }
}
