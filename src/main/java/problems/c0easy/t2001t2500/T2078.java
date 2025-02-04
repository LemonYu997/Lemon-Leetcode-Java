package problems.c0easy.t2001t2500;

/**
 * 2078 两栋颜色不同且距离最远的房子 https://leetcode.cn/problems/two-furthest-houses-with-different-colors/description/
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。
 * 给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 *
 * 示例：
 * 输入1：colors = [1,1,1,6,1,1,1]
 * 输出1：3
 *
 * 输入2：colors = [1,8,3,8,3]
 * 输出2：4
 *
 * 输入3：colors = [0,1]
 * 输出3：1
 */
public class T2078 {
    /**
     * 自己实现：考虑两个极限情况：
     * 最左侧作为初始值，从最右侧遍历找到第一个不同的值，计算距离
     * 最右侧作为初始值，从最左侧遍历找到第一个不同的值，计算距离
     */
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;

        // 最左侧作为初始值，从最右侧遍历找到第一个不同的值，计算距离
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                ans = i;
                break;
            }
        }

        // 最右侧作为初始值，从最左侧遍历找到第一个不同的值，计算距离
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                ans = Math.max(ans, n - 1 - i);
                break;
            }
        }

        return ans;
    }
}
