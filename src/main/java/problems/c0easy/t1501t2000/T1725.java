package problems.c0easy.t1501t2000;

/**
 * 1725 可以形成最大正方形的矩形数目 https://leetcode.cn/problems/number-of-rectangles-that-can-form-the-largest-square/description/
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，
 * 就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 * 请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
 *
 * 示例：
 * 输入1：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * 输出1:3
 *
 * 输入2：rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * 输出2:3
 */
public class T1725 {
    /**
     * 自己实现：统计每个矩形的最短边，找到所有最短边中最长的，统计其出现的次数即可
     */
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int ans = 0;
        for (int[] rectangle : rectangles) {
            // 找到当前矩形的最短边，作为正方形边长
            int minTemp = Math.min(rectangle[0], rectangle[1]);
            // 判断其是否为所有最短边种最长的
            if (minTemp > maxLen) {
                // 更新数据
                maxLen = minTemp;
                ans = 1;
            } else if (minTemp == maxLen) {
                ans++;
            }
        }
        return ans;
    }
}
